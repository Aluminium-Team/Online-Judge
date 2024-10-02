package com.aluminium.online_judge.IO.messageQueueIO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMessageQueueInput {
    private Long submissionId;
    private Long langId;
    private Long problemId;
    private int currentTestCase;
    private String status;
    private String code;
    private String token;

}
