package com.aluminium.online_judge.Enums;

public enum SubmissionStatus {
    IN_QUEUE,
    WRONG_ANSWER,
    TIME_LIMIT_EXCEEDED,
    RUNTIME_ERROR,
    ACCEPTED,
    COMPILATION_ERROR;

    public String getStatusMessage(int testCaseNumber) {
        return switch (this) {
            case ACCEPTED, IN_QUEUE -> this.name();
            default -> this.name() + " on test case " + testCaseNumber;
        };
    }
}
