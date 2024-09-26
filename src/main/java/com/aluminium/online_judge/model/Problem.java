package com.aluminium.online_judge.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "problems")
@Getter
@NoArgsConstructor
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

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    private List<Submission> submissions;

    private Problem(String testCasesFilePath, String name, Double timeLimit, Double memoryLimit,
                    String statement, String inputDescription, String outputDescription, String notes) {
        this.testCasesFilePath = testCasesFilePath;
        this.name = name;
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
        this.statement = statement;
        this.inputDescription = inputDescription;
        this.outputDescription = outputDescription;
        this.notes = notes;
        onCreate();
    }


    public static ProblemBuilder builder(String testCasesFilePath, String name, Double timeLimit,
                                         Double memoryLimit, String statement, String inputDescription,
                                         String outputDescription) {
        return new ProblemBuilder(testCasesFilePath, name, timeLimit, memoryLimit, statement, inputDescription, outputDescription);
    }


    public static class ProblemBuilder {
        private final String testCasesFilePath;
        private final String name;
        private final Double timeLimit;
        private final Double memoryLimit;
        private final String statement;
        private final String inputDescription;
        private final String outputDescription;
        private String notes;

        private ProblemBuilder(String testCasesFilePath, String name, Double timeLimit, Double memoryLimit,
                               String statement, String inputDescription, String outputDescription) {
            this.testCasesFilePath = testCasesFilePath;
            this.name = name;
            this.timeLimit = timeLimit;
            this.memoryLimit = memoryLimit;
            this.statement = statement;
            this.inputDescription = inputDescription;
            this.outputDescription = outputDescription;
        }

        public ProblemBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Problem build() {
            return new Problem(testCasesFilePath, name, timeLimit, memoryLimit, statement, inputDescription, outputDescription, notes);
        }
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
