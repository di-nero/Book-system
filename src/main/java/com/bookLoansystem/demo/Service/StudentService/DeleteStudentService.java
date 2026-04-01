package com.bookLoansystem.demo.Service.StudentService;

import com.bookLoansystem.demo.Entity.Student;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private Mapper mapper;

    public ResponseEntity<String> deleteStudent(Long Id) {

        Student students = studentRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("cant find Student by id: " + Id));
        students.getCourses().clear();
        studentRepository.delete(students);
        return ResponseEntity.status(HttpStatus.OK).body("student successfully deleted");

    }
}
