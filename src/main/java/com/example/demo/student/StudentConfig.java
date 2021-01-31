package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student rami = new Student(
                    "Rami",
                    "rami@gmail.com",
                    LocalDate.of(1993, Month.FEBRUARY, 7));
            Student ali = new Student(
                    "ali",
                    "ali@gmail.com",
                    LocalDate.of(1969, Month.FEBRUARY, 7));

            studentRepository.saveAll(List.of(rami, ali));
        };
    }
}
