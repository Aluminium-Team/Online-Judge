package com.aluminium.online_judge.service;

import com.aluminium.online_judge.model.Problem;
import com.aluminium.online_judge.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProblemService {

    @Autowired
    ProblemRepository problemRepository;

    public Problem getProblemById(Long id) {
        Optional<Problem> problemOptional = problemRepository.findById(id);
        return problemOptional.orElseGet(Problem::new);
    }

}
