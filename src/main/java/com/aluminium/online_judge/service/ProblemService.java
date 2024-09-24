package com.aluminium.online_judge.service;

import com.aluminium.online_judge.IO.SubmissionIO.SubmissionInput;
import com.aluminium.online_judge.model.Problem;
import com.aluminium.online_judge.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class ProblemService {

    @Autowired
    ProblemRepository problemRepository;

    public Problem getProblemById(Long problemId){
        return problemRepository.findById(problemId)
                .orElseThrow(() -> new NoSuchElementException("No problem found for ID: " + problemId));
    }

    public Problem getProblemFromSubmissionInput(SubmissionInput submissionInput){
        Long problemId = submissionInput.getProblemId();
        return getProblemById(problemId);
    }

}
