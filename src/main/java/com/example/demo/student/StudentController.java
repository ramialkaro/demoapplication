package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudent() {
        return List.of(
                new Student(1L, "Rami", "rami@gmail.com", LocalDate.of(1993, Month.FEBRUARY, 7), 28)
        );
    }

}
