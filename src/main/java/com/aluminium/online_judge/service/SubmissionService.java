package com.aluminium.online_judge.service;

import com.aluminium.online_judge.IO.createSubmissionIO.CreateSubmissionInput;
import com.aluminium.online_judge.IO.getSubmissionIO.GetSubmissionInput;
import com.aluminium.online_judge.model.Submission;
import com.aluminium.online_judge.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SubmissionService {

    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProblemService problemService;

    public void saveSubmission (Submission submission)  {
        save(submission);
        pushToQueue(submission);
    }

    public void saveSubmission(CreateSubmissionInput input){
        Submission submission = Submission.builder(
                input.getCode(),
                input.getUser(),
                input.getProblem()).build();

        saveSubmission(submission);
    }

    private void save(Submission submission) {
        submissionRepository.save(submission);
    }

    public Submission GetSubmission(GetSubmissionInput input) {
        Optional<Submission> submission = submissionRepository.findById(input.getSubmission_id());
        return submission.orElseThrow(() -> new RuntimeException("Submission Id Does Not Exist"));
    }

    private String pushToQueue(Submission submission){
        // A token should be returned
        return  "";
    }

}
