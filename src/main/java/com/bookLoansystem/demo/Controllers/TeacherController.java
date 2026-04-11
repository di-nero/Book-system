package com.bookLoansystem.demo.Controllers;

import com.bookLoansystem.demo.DTOs.TeacherDto;
import com.bookLoansystem.demo.Service.TeacherService.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private ActivateTeacherService activateTeacherService;
    @Autowired
    private DeactivateTeacherService deactivateTeacherService;
    @Autowired
    private UpdateTeacherService updateTeacherService;
    @Autowired
    private GetTeacherByIdService getTeacherByIdService;
    @Autowired
    private GetAllTeacherService getAllTeacherService;
    @Autowired
    private CreateTeacherService createTeacherService;


    //create teacher
    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@Valid @RequestBody TeacherDto teacherDto) {
        return createTeacherService.createTeacher(teacherDto);
    }

    //get all teacher
    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        return getAllTeacherService.getAllTeachers();
    }

    //get a teacher by Id
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable Long id) {
        return getTeacherByIdService.getTeacher(id);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable Long Id, @Valid @RequestBody TeacherDto newTeacher) {
        return updateTeacherService.updateTeacher(Id, newTeacher);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deactivateTeacher(@PathVariable Long Id) {
        return deactivateTeacherService.deactivateTeacher(Id);
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<TeacherDto> activateTeacher(@PathVariable Long id) {
        return activateTeacherService.activateTeacher(id);
    }
}
