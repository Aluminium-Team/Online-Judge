package com.aluminium.online_judge.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
@Getter
@NoArgsConstructor
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String status;

    @NonNull
    @Column(name = "judge0_reference_token")
    private String judge0ReferenceToken;

    @NonNull
    @Column(name = "time")
    private Double time;

    @NonNull
    @Column(name = "memory")
    private Double memory;

    @NonNull
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "created_at", nullable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;

    @NonNull
    @Column(name = "current_test_case")
    private Integer currentTestCase = 0;

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

    private Submission(String status, String judge0ReferenceToken, Double time, Double memory,
                       String code, Integer currentTestCase, User user, Problem problem) {
        this.status = status;
        this.judge0ReferenceToken = judge0ReferenceToken;
        this.time = time;
        this.memory = memory;
        this.code = code;
        this.currentTestCase = currentTestCase;
        this.user = user;
        this.problem = problem;
        onCreate();
    }

    public static SubmissionBuilder builder(String status, String judge0ReferenceToken, Double time,
                                            Double memory, String code, Integer currentTestCase, User user, Problem problem) {
        return new SubmissionBuilder(status, judge0ReferenceToken, time, memory, code, currentTestCase, user, problem);
    }

    public static class SubmissionBuilder {
        private final String status;
        private final String judge0ReferenceToken;
        private final Double time;
        private final Double memory;
        private final String code;
        private final Integer currentTestCase;
        private final User user;
        private final Problem problem;

        public SubmissionBuilder(String status, String judge0ReferenceToken, Double time,
                                 Double memory, String code, Integer currentTestCase, User user, Problem problem) {
            this.status = status;
            this.judge0ReferenceToken = judge0ReferenceToken;
            this.time = time;
            this.memory = memory;
            this.code = code;
            this.currentTestCase = currentTestCase;
            this.user = user;
            this.problem = problem;
        }

        public Submission build() {
            return new Submission(status, judge0ReferenceToken, time, memory, code, currentTestCase, user, problem);
        }
    }

    // Setters
    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
