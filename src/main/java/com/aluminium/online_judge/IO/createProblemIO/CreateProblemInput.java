package com.aluminium.online_judge.IO.createProblemIO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProblemInput {
    String testCasesPathFile;
    String name;
    Double timeLimit;
    Double memoryLimit;
    String statement;
    String inputDescription;
    String outputDescription;
    String notes;
}
