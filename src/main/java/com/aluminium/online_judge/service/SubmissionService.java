package com.aluminium.online_judge.service;

import com.aluminium.online_judge.model.Problem;
import com.aluminium.online_judge.model.Submission;
import com.aluminium.online_judge.model.User;
import com.aluminium.online_judge.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class SubmissionService {

    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProblemService problemService;

    public Submission saveSubmission(Submission submission, UUID userId, Long problemId){
        User user = userService.getUserById(userId);
        Optional<Problem> problemExists = problemService.getProblemById(problemId);
        if (problemExists.isPresent()){
            Problem problem = problemExists.get();
            submission.setProblem(problem);
        }else{
            throw new NoSuchElementException("Problem not found for the given ID.");
        }
        submission.setStatus("IN QUEUE");
        submission.setUser(user);

        try {
            return submissionRepository.save(submission);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("exisstsss");
        }

    }

    public String pushSubmissionToQueue(Submission submission){
        // a token should be returned
        return  "";
    }

}