package com.bookLoansystem.demo.Service.CourseService;


import com.bookLoansystem.demo.DTOs.CourseDto;
import com.bookLoansystem.demo.Entity.Teacher;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.CourseRepository;
import com.bookLoansystem.demo.Repositories.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CreateCourseService {

    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public Mapper mapper;
    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    public ResponseEntity<CourseDto> createCourse(CourseDto courseDto) {

        if (courseRepository.existsByTitle(courseDto.getTitle())) {
            throw new RuntimeException("Course already exists: " + courseDto.getTitle());
        }

        var course = mapper.toCourseEntity(courseDto);

        Teacher teacher = teacherRepository.findById(courseDto.getTeacherId())
                .orElseThrow(() -> new ResourceNotFoundException("cant find teacher with id: " + courseDto.getTeacherId()));

        if (!teacher.isActive()) {
            throw new ResourceNotFoundException("Cannot assign course to inactive teacher");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);

        var result = mapper.toCourseDto(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
