package com.aluminium.online_judge.service;

import com.aluminium.online_judge.IO.SubmissionIO.SubmissionInput;
import com.aluminium.online_judge.model.Problem;
import com.aluminium.online_judge.model.Submission;
import com.aluminium.online_judge.model.User;
import com.aluminium.online_judge.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {

    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProblemService problemService;

    private Submission saveSubmission(Submission submission){

        return submissionRepository.save(submission);

    }

    private String pushSubmissionToQueue(Submission submission){
        // A token should be returned
        return  "";
    }



    public void handleSubmission(SubmissionInput submissionInput, Authentication authentication){

        User user = userService.getUserFromAuth(authentication);
        Problem problem = problemService.getProblemFromSubmissionInput(submissionInput);

        Submission submission = createSubmission(submissionInput,user,problem);

        saveSubmissionAndPushToQueue(submission);

    }

    public void saveSubmissionAndPushToQueue(Submission submission){
        saveSubmission(submission);
        String submissionReferenceToken = pushSubmissionToQueue(submission);
    }



    private Submission createSubmission(SubmissionInput submissionInput, User user, Problem problem) {
        return Submission.builder(
                "IN QUEUE"
                ,submissionInput.getCode()
                ,0
                ,user
                ,problem)
                .build();
    }
}
