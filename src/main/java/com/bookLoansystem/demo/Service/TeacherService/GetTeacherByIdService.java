package com.bookLoansystem.demo.Service.TeacherService;

import com.bookLoansystem.demo.DTOs.TeacherDto;
import com.bookLoansystem.demo.Entity.Teacher;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class GetTeacherByIdService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private Mapper mapper;

    public ResponseEntity<TeacherDto> getTeacher(Long id){

        Teacher teacher = teacherRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("cant find teacher by ID of " + id));
        var result = mapper.toTeacherdto(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
