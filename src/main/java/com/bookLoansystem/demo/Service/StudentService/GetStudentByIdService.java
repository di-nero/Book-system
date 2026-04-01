package com.bookLoansystem.demo.Service.StudentService;


import com.bookLoansystem.demo.DTOs.StudentDto;
import com.bookLoansystem.demo.Entity.Student;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetStudentByIdService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private Mapper mapper;

    public ResponseEntity<StudentDto> getStudent(Long id){

        Student students = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("cant find Student by ID of " + id));
        var student = mapper.toStudentDto(students);
        return ResponseEntity.status(HttpStatus.OK).body(student);

    }

}
