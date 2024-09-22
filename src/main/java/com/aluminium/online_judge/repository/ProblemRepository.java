package com.aluminium.online_judge.repository;

import com.aluminium.online_judge.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
