package com.bookLoansystem.demo.Service.TeacherService;

import com.bookLoansystem.demo.DTOs.TeacherDto;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private Mapper mapper;

    public ResponseEntity<List<TeacherDto>> getAllTeachers(){

        var result =  teacherRepository
                .findAll()
                .stream()
                .map(teacher -> mapper.toTeacherdto(teacher))
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
