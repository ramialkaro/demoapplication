package com.example.demo.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"

    )
    private Long id;
    private String name;
    private LocalDate createdAt;

    public Course() {
    }

    public Course(Long id, String name, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Course(String name, LocalDate createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
