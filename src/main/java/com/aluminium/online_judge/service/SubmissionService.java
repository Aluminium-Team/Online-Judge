package com.aluminium.online_judge.service;

import com.aluminium.online_judge.Enums.SubmissionStatus;
import com.aluminium.online_judge.Facades.SubmissionFacade;
import com.aluminium.online_judge.IO.createSubmissionIO.CreateSubmissionInput;
import com.aluminium.online_judge.IO.getSubmissionIO.GetSubmissionInput;
import com.aluminium.online_judge.model.Problem;
import com.aluminium.online_judge.model.Submission;
import com.aluminium.online_judge.model.User;
import com.aluminium.online_judge.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public void SaveInRepo(Submission submission) {
        submissionRepository.save(submission);
    }

    public void saveSubmission(CreateSubmissionInput input){

        Submission submission = Submission.builder(
                input.getCode(),
                input.getUser(),
                input.getProblem()).build();

        SubmissionFacade.saveSubmission(submission);

    }


    public Submission GetSubmission(GetSubmissionInput input) {
        Optional<Submission> submission = submissionRepository.findById(input.getSubmission_id());
        if (submission.isPresent()) {
            return submission.get();
        } else {
            throw new RuntimeException("Submission Id Does Not Exist");
        }

    }


    public String pushSubmissionToQueue(Submission submission){
        // A token should be returned
        return  "";
    }

}
