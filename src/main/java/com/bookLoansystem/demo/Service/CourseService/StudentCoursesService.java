package com.bookLoansystem.demo.Service.CourseService;


import com.bookLoansystem.demo.DTOs.StudentCourseDto;
import com.bookLoansystem.demo.Entity.Course;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentCoursesService {

    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public Mapper mapper;

    public ResponseEntity<List<StudentCourseDto>> studentCourses(Long id){
        Course course = courseRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("cant find course with id: " + id));
        var result = course.getStudents()
                .stream()
                .map(mapper::toStudentCourseDto)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
