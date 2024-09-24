package com.aluminium.online_judge.repository;

import com.aluminium.online_judge.model.Problem;
import com.aluminium.online_judge.model.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
