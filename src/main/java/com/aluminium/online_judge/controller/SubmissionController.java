package com.aluminium.online_judge.controller;

import com.aluminium.online_judge.DTOs.CreateSubmissionDTO;
import com.aluminium.online_judge.DTOs.GetSubmissionDTO;
import com.aluminium.online_judge.IO.GetStatusIO.GetStatusOutput;
import com.aluminium.online_judge.IO.createSubmissionIO.CreateSubmissionInput;
import com.aluminium.online_judge.IO.getSubmissionIO.GetSubmissionInput;
import com.aluminium.online_judge.converters.CreateSubmissionConverter;
import com.aluminium.online_judge.converters.GetStatusConverter;
import com.aluminium.online_judge.converters.GetSubmissionConverter;
import com.aluminium.online_judge.model.Submission;
import com.aluminium.online_judge.repository.SubmissionRepository;
import com.aluminium.online_judge.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/users")
public class SubmissionController {

    @Autowired
    SubmissionService submissionService;

    @PostMapping("/submit")
    public ResponseEntity<Void> createSubmission(@RequestBody CreateSubmissionDTO createSubmissionInputDT0, Authentication authentication){

        CreateSubmissionInput createSubmissionInput = CreateSubmissionConverter.toCreateSubmissionInput(
                createSubmissionInputDT0,
                authentication
        );
        submissionService.saveSubmission(createSubmissionInput);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/Status")
    public  ResponseEntity<GetStatusOutput> getSubmission(@RequestBody GetSubmissionDTO getSubmissionDTO) {
        GetSubmissionInput getSubmissionInput = GetSubmissionConverter.toGetSubmissionInput(
                getSubmissionDTO
        );

        Submission submission = submissionService.GetSubmission(getSubmissionInput);
        GetStatusOutput getStatusOutput = GetStatusConverter.toStatus(submission);

        return new ResponseEntity<GetStatusOutput>(getStatusOutput,HttpStatus.CREATED);
    }

}

