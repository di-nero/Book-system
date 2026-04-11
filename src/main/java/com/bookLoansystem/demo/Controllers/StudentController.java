package com.bookLoansystem.demo.Controllers;

import com.bookLoansystem.demo.DTOs.StudentDto;
import com.bookLoansystem.demo.Service.StudentService.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    @Autowired
    private DropACourseService dropACourseService;
    @Autowired
    private EnrollStudentService enrollStudentService;
    @Autowired
    private DeleteStudentService deleteStudentService;
    @Autowired
    private UpdateStudentService updateStudentService;
    @Autowired
    private GetStudentByIdService getStudentByIdService;
    @Autowired
    private GetAllStudentService getAllStudentService;
    @Autowired
    private CreateStudentService createStudentService;

    @PostMapping
    //create student controller
    public ResponseEntity<Object> createStudent(@Valid @RequestBody StudentDto studentDto){
       return createStudentService.createStudent(studentDto);
    }

    //get all student
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return getAllStudentService.getAllStudents();
    }

    //get a student by Id
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id){
        return getStudentByIdService.getStudent(id);
    }

    //update a student
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id , @Valid @RequestBody StudentDto newStudent){
        return ResponseEntity.ok(updateStudentService.updateStudent(id , newStudent));
    }
    
    //delete a student
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long Id) {
        return deleteStudentService.deleteStudent(Id);
    }

    //enroll student for a course
    @PostMapping("/{studentId}/enroll/{courseId}")
    @Transactional
    public ResponseEntity<StudentDto> enrollStudent
    (@PathVariable Long studentId , @PathVariable Long courseId){
        return enrollStudentService.enrollStudent(studentId , courseId);
    }

//drop a course
    @DeleteMapping("/{studentId}/enroll/{courseId}")
    @Transactional
    public ResponseEntity<StudentDto> dropCourse(@PathVariable Long studentId , @PathVariable Long courseId){
        return dropACourseService.dropCourse(studentId , courseId);
    }
}
