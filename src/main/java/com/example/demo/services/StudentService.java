package com.example.demo.services;

import com.example.demo.model.dtos.StudentDto;
import com.example.demo.model.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Integer addStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        return studentRepository.save(student).getId();
    }

    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        studentRepository.findAll().forEach(student -> {
            StudentDto studentDto = new StudentDto();
            studentDto.setName(student.getName());
            studentDto.setAge(student.getAge());
            studentDtoList.add(studentDto);
        });
        return studentDtoList;
    }
}
