package com.aluminium.online_judge.controller;

import com.aluminium.online_judge.model.Submission;
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
@RequestMapping(path = "/api/v1/users")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PostMapping("/submit")
    public ResponseEntity<String> createSubmission(@RequestBody Submission submission, Authentication authentication) {
        UUID userId = (UUID) authentication.getPrincipal();

        try {
            Long problemId = submission.getProblem().getId();
            submissionService.saveSubmission(submission, userId, problemId);
            submissionService.pushSubmissionToQueue(submission);
            return ResponseEntity.status(HttpStatus.OK).body("Submission sent successfully.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Problem not found for the given ID.");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Submission data is invalid.");
        }
    }
}
