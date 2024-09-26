package com.aluminium.online_judge.converters;

import com.aluminium.online_judge.DTOs.GetSubmissionDTO;
import com.aluminium.online_judge.IO.getSubmissionIO.GetSubmissionInput;
import com.aluminium.online_judge.service.SubmissionService;

public class GetSubmissionConverter {

    private static SubmissionService submissionService;

    public static GetSubmissionInput toGetSubmissionInput(GetSubmissionDTO getSubmissionDTO){
        Long submissionId = getSubmissionDTO.getSubmission_id();

        if (submissionId != null) {
            GetSubmissionInput getSubmissionInput = new GetSubmissionInput(submissionId);
            return getSubmissionInput;
        } else {
            throw new RuntimeException("Submission Id Is Null");
        }
    }


}
