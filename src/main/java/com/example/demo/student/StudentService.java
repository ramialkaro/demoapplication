package com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
       return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentOptionalByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptionalByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw  new IllegalStateException(
                    "student with id " + studentId + " dost not exists"
            );
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email){
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("student with id "+ id + "dose not exists"));
        if(name !=null
                && name.length() > 0
                && Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if(email !=null
                && email.length() > 0
                && Objects.equals(student.getEmail(), email)){
            Optional<Student> existsStudent = studentRepository.findStudentByEmail(email);
            if(existsStudent.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
