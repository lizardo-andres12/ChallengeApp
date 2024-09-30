package com.example.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();
    private long nextId = 1;

    public ChallengeService() {
        challenges.add(new Challenge(1L, "January", "Learn a new programming language"));
    }

    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        } else {
            return false;
        }
    }

    public Challenge getChallenge(String month) {
        for (Challenge challenge : challenges) {
            if (challenge.getMonth().equalsIgnoreCase(month)) {
                return challenge;
            }
        }
        return null;
    }

    public boolean updateChallenge(long id, Challenge updateChallenge) {
        for (Challenge challenge : challenges) {
            if (challenge.getId() == id) {
                challenge.setMonth(updateChallenge.getMonth());
                challenge.setDescription(updateChallenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(long id) {
        // challenge (individual element in List<>) -> (do if) challenge.getId() == id
        return challenges.removeIf(challenge -> challenge.getId() == id);
    }
}
