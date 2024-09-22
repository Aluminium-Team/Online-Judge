package com.aluminium.online_judge.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;

    @Column(name = "judge0_reference_token")
    private String judge0ReferenceToken;

    @Column(name = "time")
    private Double time;

    @Column(name = "memory")
    private Double memory;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "current_test_case")
    private Integer currentTestCase;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
