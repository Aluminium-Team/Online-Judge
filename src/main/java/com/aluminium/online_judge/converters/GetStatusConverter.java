package com.aluminium.online_judge.converters;

import com.aluminium.online_judge.IO.GetStatusIO.GetStatusOutput;
import com.aluminium.online_judge.model.Submission;

public class GetStatusConverter {
    public static GetStatusOutput toStatus(Submission submission) {
        return new GetStatusOutput(submission
                .getStatus()
                .getStatusMessage(submission.getCurrentTestCase())
        );
    }
}
