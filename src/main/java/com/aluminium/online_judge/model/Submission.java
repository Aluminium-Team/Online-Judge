package com.aluminium.online_judge.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Builder(builderMethodName = "lombokBuilder")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String status;

    @Column(name = "judge0_reference_token")
    private String judge0ReferenceToken;

    @Column(name = "time")
    private Double time;

    @Column(name = "memory")
    private Double memory;

    @NonNull
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @NonNull
    @Column(name = "current_test_case")
    private Integer currentTestCase;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public static SubmissionBuilder builder(String status,
                                                 String code,
                                                 Integer currentTestCase,
                                                 User user,
                                                 Problem problem) {
        return lombokBuilder()
                .status(status)
                .code(code)
                .currentTestCase(currentTestCase)
                .user(user)
                .problem(problem);
    }
}
