package com.example.ChallengeApp;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    Optional<List<Challenge>> findAllByMonthIgnoreCase(String month);
}
