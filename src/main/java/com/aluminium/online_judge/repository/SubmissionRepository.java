package com.aluminium.online_judge.repository;

import com.aluminium.online_judge.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
