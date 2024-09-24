package com.aluminium.online_judge.controller;

import com.aluminium.online_judge.IO.SubmissionIO.SubmissionInput;
import com.aluminium.online_judge.model.Submission;
import com.aluminium.online_judge.repository.SubmissionRepository;
import com.aluminium.online_judge.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1")
public class SubmissionController {

    @Autowired
    SubmissionService submissionService;

    @PostMapping("/submit")
    public ResponseEntity<String> receiveSubmission(@RequestBody SubmissionInput submissionInput, Authentication authentication){

        submissionService.handleSubmission(submissionInput,authentication);

        return ResponseEntity.status(HttpStatus.CREATED).body("Submission sent successfully.");

    }
}

