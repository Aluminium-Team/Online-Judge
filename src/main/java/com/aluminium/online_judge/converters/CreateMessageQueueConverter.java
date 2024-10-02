package com.aluminium.online_judge.converters;

import com.aluminium.online_judge.IO.createSubmissionIO.CreateSubmissionInput;
import com.aluminium.online_judge.IO.messageQueueIO.CreateMessageQueueInput;
import com.aluminium.online_judge.model.Submission;
import com.aluminium.online_judge.model.User;
import org.springframework.stereotype.Component;

@Component
public class CreateMessageQueueConverter {
    public static CreateMessageQueueInput toCreateMessageQueueInput(Submission submission) {

        Long id = submission.getId();
        int langId = submission.getLangId();
        User user = submission.getUser();
        Long problemId = submission.getProblem().getId();
        Integer currentTestcase = submission.getCurrentTestCase();
        String status = submission.getStatus().getStatusMessage(currentTestcase);
        String code =  submission.getCode();
        String token = submission.getJudge0ReferenceToken();



        CreateMessageQueueInput createMessageQueueInput = new CreateMessageQueueInput(
                id,
                langId,
                problemId,
                currentTestcase,
                status,
                code,
                token
        );

        return createMessageQueueInput;
    }
}
