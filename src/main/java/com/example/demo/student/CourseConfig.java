package com.example.demo.student;

import com.example.demo.model.Course;
import com.example.demo.repoistory.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CourseConfig {

    @Bean
    CommandLineRunner commandLineRunnerCourse(CourseRepository courseRepository) {
        return args -> {
            Course course_one = new Course("Spring boot", LocalDate.of(2021, Month.JANUARY, 21));
            Course course_two = new Course("Git", LocalDate.of(2019, Month.APRIL, 6));
            courseRepository.saveAll(List.of(course_one, course_two));
        };
    }
}
