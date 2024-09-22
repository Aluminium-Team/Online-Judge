package com.aluminium.online_judge.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "problems")
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "test_cases_file_path", nullable = false)
    private String testCasesFilePath;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column(name = "time_limit", nullable = false)
    private Double timeLimit;

    @NonNull
    @Column(name = "memory_limit", nullable = false)
    private Double memoryLimit;

    @NonNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String statement;

    @NonNull
    @Column(name = "input_description", columnDefinition = "TEXT")
    private String inputDescription;

    @NonNull
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

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
