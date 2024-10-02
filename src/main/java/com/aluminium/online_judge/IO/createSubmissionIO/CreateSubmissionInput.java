package com.aluminium.online_judge.IO.createSubmissionIO;

import com.aluminium.online_judge.model.Problem;
import com.aluminium.online_judge.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateSubmissionInput {
    User user;
    Problem problem;
    String code;
}
