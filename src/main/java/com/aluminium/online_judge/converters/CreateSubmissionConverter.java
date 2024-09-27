package com.aluminium.online_judge.converters;

import com.aluminium.online_judge.DTOs.CreateSubmissionDTO;
import com.aluminium.online_judge.IO.createSubmissionIO.CreateSubmissionInput;
import com.aluminium.online_judge.IO.getSubmissionIO.GetSubmissionInput;
import com.aluminium.online_judge.model.Problem;
import com.aluminium.online_judge.model.User;
import com.aluminium.online_judge.service.ProblemService;
import com.aluminium.online_judge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateSubmissionConverter {

    @Autowired
    private UserService userService;

    @Autowired
    private ProblemService problemService;

    public CreateSubmissionInput toCreateSubmissionInput(CreateSubmissionDTO submissionInputDT0, Authentication authentication) {

        Long problem_id = submissionInputDT0.getProblem_id();
        String code = submissionInputDT0.getCode();
        Integer lang_id = submissionInputDT0.getLang_id();

        if (problem_id != null && code != null && lang_id != null) {
            User user = userService.getUserById((UUID)authentication.getPrincipal());
            Problem problem = problemService.getProblemById(submissionInputDT0.getProblem_id());
            CreateSubmissionInput createSubmissionInput = new CreateSubmissionInput(user, problem, submissionInputDT0.getCode());

            return createSubmissionInput;
        } else if (problem_id != null) {
            throw new RuntimeException("Problem Id Is Null");
        } else if (code != null) {
            throw new RuntimeException("Code Is Null");
        } else {
            throw new RuntimeException("Lang Id Is Null");
        }
    }
}
