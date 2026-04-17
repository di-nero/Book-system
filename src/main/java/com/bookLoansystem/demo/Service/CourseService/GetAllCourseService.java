package com.bookLoansystem.demo.Service.CourseService;


import com.bookLoansystem.demo.DTOs.CourseDto;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCourseService {

    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public Mapper mapper;

    @Transactional
    public ResponseEntity<List<CourseDto>> getAllCourse(){

        var result =  courseRepository
                .findAll()
                .stream()
                .map(course -> mapper.toCourseDto(course))
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
