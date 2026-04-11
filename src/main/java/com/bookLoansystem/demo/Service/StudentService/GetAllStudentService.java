package com.bookLoansystem.demo.Service.StudentService;

import com.bookLoansystem.demo.DTOs.StudentDto;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private Mapper mapper;

    @Transactional
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        var result = studentRepository
                .findAll()
                .stream()
                .map(student -> mapper.toStudentDto(student))
                .toList();
        return ResponseEntity.ok(result);
    }
}
