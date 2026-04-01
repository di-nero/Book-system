package com.bookLoansystem.demo.Service.StudentService;


import com.bookLoansystem.demo.DTOs.StudentDto;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service


public class CreateStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private Mapper mapper;

    public ResponseEntity<Object> createStudent(StudentDto studentDto){

        if (studentRepository.existsByEmail(studentDto.getEmail())) {
            throw new ResourceNotFoundException("Email already exists: " + studentDto.getEmail());
        }

        var student = mapper.toStudentEntity(studentDto);

        if (student.getStudentProfile() != null){
            student.getStudentProfile().setStudent(student);
        }
        studentRepository.save(student);
        var result = mapper.toStudentDto(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
