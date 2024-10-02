package com.aluminium.online_judge.service;

import com.aluminium.online_judge.IO.createSubmissionIO.CreateSubmissionInput;
import com.aluminium.online_judge.IO.getSubmissionIO.GetSubmissionInput;
import com.aluminium.online_judge.IO.messageQueueIO.CreateMessageQueueInput;
import com.aluminium.online_judge.converters.CreateMessageQueueConverter;
import com.aluminium.online_judge.converters.CreateSubmissionConverter;
import com.aluminium.online_judge.model.Submission;
import com.aluminium.online_judge.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class SubmissionService {

    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProblemService problemService;

    @Autowired
    private RestTemplate restTemplate;



    public void saveSubmission(CreateSubmissionInput input){
        Submission submission = Submission.builder(
                input.getCode(),
                input.getUser(),
                input.getProblem()).build();

        saveSubmission(submission);
    }

    public void saveSubmission (Submission submission)  {
        save(submission);
        pushToQueue(submission);
    }

    private void save(Submission submission) {
        submissionRepository.save(submission);
    }

    public Submission GetSubmission(GetSubmissionInput input) {
        Optional<Submission> submission = submissionRepository.findById(input.getSubmission_id());
        return submission.orElseThrow(() -> new RuntimeException("Submission Id Does Not Exist"));
    }

    private String pushToQueue(Submission submission){
        CreateMessageQueueInput createMessageQueueInput = CreateMessageQueueConverter.toCreateMessageQueueInput(
                submission);

        System.out.println(createMessageQueueInput.getSubmissionId());

        String url = "http://127.0.0.1:1111/api/redis/push";
        String response = restTemplate.postForObject(url, createMessageQueueInput, String.class);

        return response;
    }

}
