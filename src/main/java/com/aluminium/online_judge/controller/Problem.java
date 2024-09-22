package com.aluminium.online_judge.controller;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "problems")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test_cases_file_path", nullable = false)
    private String testCasesFilePath;

    @Column(nullable = false)
    private String name;

    @Column(name = "time_limit", nullable = false)
    private Double timeLimit;

    @Column(name = "memory_limit", nullable = false)
    private Double memoryLimit;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String statement;

    @Column(name = "input_description", columnDefinition = "TEXT")
    private String inputDescription;

    @Column(name = "output_description", columnDefinition = "TEXT")
    private String outputDescription;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    private List<Submission> submissions;
}
