package com.example.ChallengeApp;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        // Spring Boot provides all dependencies at runtime
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean success = challengeService.addChallenge(challenge);
        if (success) {
            return new ResponseEntity<>("Challenge added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge not added successfully", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month) {
        Challenge challenge = challengeService.getChallenge(month);
        if (challenge != null) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable long id, @RequestBody Challenge updateChallenge) {
        boolean updated = challengeService.updateChallenge(id, updateChallenge);
        if (updated) {
            return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid challenge id", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable long id) {
        boolean deleted = challengeService.deleteChallenge(id);
        if (deleted) {
            return new ResponseEntity<>("Challenge deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid challenge id", HttpStatus.NOT_FOUND);
        }
    }
}
