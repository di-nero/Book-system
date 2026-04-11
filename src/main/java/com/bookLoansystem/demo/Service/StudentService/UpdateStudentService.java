package com.bookLoansystem.demo.Service.StudentService;


import com.bookLoansystem.demo.DTOs.StudentDto;
import com.bookLoansystem.demo.Entity.Student;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private Mapper mapper;

    public StudentDto updateStudent(Long id ,  StudentDto newStudent){

        Student students = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("cant find Student by id: " + id));

        if (studentRepository.existsByEmailAndIdNot(newStudent.getEmail(), id)) {
            throw new RuntimeException("Email already exists: " + newStudent.getEmail());
        }

        students.setName(newStudent.getName());
        students.setEmail(newStudent.getEmail());

        studentRepository.save(students);
        return mapper.toStudentDto(students);
    }
}
