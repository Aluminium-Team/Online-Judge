package com.aluminium.online_judge.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
@Data
@Builder
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Submission() {
        //Builder will not work without no args constructor
    }
}
