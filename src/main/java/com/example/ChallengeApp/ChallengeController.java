package com.example.ChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {
    private List<Challenge> challenges = new ArrayList<>();

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge challenge) {
        challenges.add(challenge);
        return "Challenge added successfully";
    }
}
