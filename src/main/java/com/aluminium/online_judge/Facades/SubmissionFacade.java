package com.aluminium.online_judge.Facades;

import com.aluminium.online_judge.Enums.SubmissionStatus;
import com.aluminium.online_judge.model.Submission;
import com.aluminium.online_judge.repository.SubmissionRepository;
import com.aluminium.online_judge.service.SubmissionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class SubmissionFacade {


    static SubmissionService submissionService = new SubmissionService();


    public static void saveSubmission (Submission submission)  {
        submissionService.SaveInRepo(submission);
        submissionService.pushSubmissionToQueue(submission);
    }

}
