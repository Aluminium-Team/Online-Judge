package com.aluminium.online_judge;

import com.aluminium.online_judge.model.Problem;
import com.aluminium.online_judge.repository.ProblemRepository; // Make sure you have this repository
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ProblemTestRunner implements ApplicationRunner {

    @Autowired
    private ProblemRepository problemRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
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

        problemRepository.save(problem);

        System.out.println("Problem ID: " + problem.getId());
        System.out.println("Created At: " + problem.getCreatedAt());
        System.out.println("Updated At: " + problem.getUpdatedAt());
    }
}
