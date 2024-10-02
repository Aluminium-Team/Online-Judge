package com.aluminium.online_judge.controller;

import com.aluminium.online_judge.IO.createProblemIO.CreateProblemInput;
import com.aluminium.online_judge.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/problems")
public class ProblemController {

    @Autowired
    ProblemService problemService;

    @PostMapping("/create")
    public ResponseEntity<Void> addProblem(@RequestBody CreateProblemInput createProblemInput, Authentication authentication) {

        problemService.addProblem(createProblemInput);

        return new ResponseEntity<>(HttpStatus.CREATED);


    }
}
