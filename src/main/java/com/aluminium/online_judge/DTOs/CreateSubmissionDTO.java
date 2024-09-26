package com.aluminium.online_judge.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateSubmissionDTO {
    Long problem_id;
    String code;
    Integer lang_id;
}
