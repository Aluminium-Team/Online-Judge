package com.aluminium.online_judge.service;

import com.aluminium.online_judge.IO.createProblemIO.CreateProblemInput;
import com.aluminium.online_judge.model.Problem;
import com.aluminium.online_judge.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProblemService {

    @Autowired
    ProblemRepository problemRepository;

    public Problem getProblemById(Long id) {
        Optional<Problem> problemOptional = problemRepository.findById(id);
        return problemOptional.orElseGet(Problem::new);
    }

    public void saveProblem(Problem problem) {
        problemRepository.save(problem);
    }

    public void addProblem(CreateProblemInput input) {
        Problem problem = Problem.builder(
                input.getTestCasesPathFile(),
                input.getName(),
                input.getTimeLimit(),
                input.getMemoryLimit(),
                input.getStatement(),
                input.getInputDescription(),
                input.getOutputDescription(),
                input.getNotes()).build();

        saveProblem(problem);

    }

}
