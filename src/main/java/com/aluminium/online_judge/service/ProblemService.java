package com.aluminium.online_judge.service;

import com.aluminium.online_judge.model.Problem;
import com.aluminium.online_judge.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProblemService {

    @Autowired
    ProblemRepository problemRepository;

    public Optional<Problem> getProblemById(Long problemId){
        return problemRepository.findById(problemId);
    }

    public Problem createProblem(){
        Problem problem = Problem.builder(
                        "path/to/testcases",
                        "Sample Problem",
                        1.5,
                        128.0,
                        "Problem statement.",
                        "Input description.",
                        "Output description."
                ).notes("Additional notes.")
                .build();

        return problemRepository.save(problem);
    }
}