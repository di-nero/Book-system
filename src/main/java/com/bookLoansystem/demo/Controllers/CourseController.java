package com.bookLoansystem.demo.Controllers;

import com.bookLoansystem.demo.DTOs.CourseDto;
import com.bookLoansystem.demo.DTOs.StudentCourseDto;
import com.bookLoansystem.demo.Repositories.CourseRepository;
import com.bookLoansystem.demo.Service.CourseService.CreateCourseService;
import com.bookLoansystem.demo.Service.CourseService.GetAllCourseService;
import com.bookLoansystem.demo.Service.CourseService.StudentCoursesService;
import com.bookLoansystem.demo.Service.CourseService.UpdateCourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private UpdateCourseService updateCourseService;
    @Autowired
    private StudentCoursesService studentCoursesService;
    @Autowired
    private GetAllCourseService getAllCourseService;
    @Autowired
    private CreateCourseService createCourseService;
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseDto courseDto) {
        return createCourseService.createCourse(courseDto);
    }

    //list all course
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourse(){
        return getAllCourseService.getAllCourse();
    }

    //list student in a course
    @GetMapping("/{id}/students")
    public  ResponseEntity<List<StudentCourseDto>> studentCourses(@PathVariable Long id){
     return studentCoursesService.studentCourses(id);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long Id , @Valid @RequestBody CourseDto newCourse){
        return updateCourseService.updateCourse(Id , newCourse);
    }

}
