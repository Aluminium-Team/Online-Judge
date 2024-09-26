package com.aluminium.online_judge.converters;

import com.aluminium.online_judge.Enums.SubmissionStatus;
import com.aluminium.online_judge.IO.GetStatusIO.GetStatusOutput;
import com.aluminium.online_judge.model.Submission;

public class GetStatusConverter {
    public static GetStatusOutput toStatus(Submission submission) {
        SubmissionStatus status = submission.getStatus();

        // TODO: Create Methods in Enum

        if (status.equals(SubmissionStatus.IN_QUEUE)) {
            GetStatusOutput getStatusOutput = new GetStatusOutput("IN Queue");
            return getStatusOutput;
        }

        if (status.equals(SubmissionStatus.ACCEPTED)) {
            GetStatusOutput getStatusOutput = new GetStatusOutput("Accepted");
            return getStatusOutput;
        }

        if (status.equals(SubmissionStatus.COMPILATION_ERROR)) {
            GetStatusOutput getStatusOutput = new GetStatusOutput("Compilation Error");
            return getStatusOutput;
        }

        if (status.equals(SubmissionStatus.RUNTIME_ERROR)) {
            Integer currentTestCase = submission.getCurrentTestCase();
            GetStatusOutput getStatusOutput = new GetStatusOutput("Runtime Error On Test Case " + currentTestCase);
            return getStatusOutput;
        }

        if (status.equals(SubmissionStatus.TIME_LIMIT_EXCEEDED)) {
            Integer currentTestCase = submission.getCurrentTestCase();
            GetStatusOutput getStatusOutput = new GetStatusOutput("Time Limit Exceeded On Test Case " + currentTestCase);
            return getStatusOutput;
        }

        if (status.equals(SubmissionStatus.WRONG_ANSWER)) {
            Integer currentTestCase = submission.getCurrentTestCase();
            GetStatusOutput getStatusOutput = new GetStatusOutput("Wrong Answer On Test Case " + currentTestCase);
            return getStatusOutput;
        }

        throw new RuntimeException("Submission Status Does Not Exist");


    }
}
