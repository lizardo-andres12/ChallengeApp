package com.example.ChallengeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    private long nextId = 1;

    @Autowired
    ChallengeRepository challengeRepository;

    public ChallengeService() {};

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challengeRepository.save(challenge);
            return true;
        } else {
            return false;
        }
    }

    public List<Challenge> getChallenge(String month) {
        Optional<List<Challenge>> challenge = challengeRepository.findAllByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }

    public boolean updateChallenge(long id, Challenge updateChallenge) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent()) {
            Challenge challengeToUpdate = challenge.get();
            challengeToUpdate.setMonth(updateChallenge.getMonth());
            challengeToUpdate.setDescription(updateChallenge.getDescription());
            challengeRepository.save(challengeToUpdate);
            return true;
        }
        return false;
    }

    public boolean deleteChallenge(long id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent()) {
            challengeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
