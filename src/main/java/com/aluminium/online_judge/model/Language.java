package com.aluminium.online_judge.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true, nullable=false)
    private String name;
    @Column(name = "time_increase_factor")
    private double timeIncrementFactor = 1.0; // for the future if we wanted to increase the time limit for some languages
    @Column(name = "memory_increase_factor")
    private double memoryIncrementFactor = 1.0; //for the future if we wanted to increase the memory limit for some languages

    public Language() {}

    public Language(String name, double timeIncrementFactor, double memoryIncrementFactor) {
        this.name = name;
        this.timeIncrementFactor = timeIncrementFactor;
        this.memoryIncrementFactor = memoryIncrementFactor;
    }
}
