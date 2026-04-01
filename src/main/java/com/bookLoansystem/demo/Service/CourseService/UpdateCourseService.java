package com.bookLoansystem.demo.Service.CourseService;


import com.bookLoansystem.demo.DTOs.CourseDto;
import com.bookLoansystem.demo.Entity.Course;
import com.bookLoansystem.demo.Entity.Teacher;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.CourseRepository;
import com.bookLoansystem.demo.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UpdateCourseService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public Mapper mapper;

    public ResponseEntity<CourseDto> updateCourse(Long Id , CourseDto newCourse){

        Course course = courseRepository
                .findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("cant find Course with id: " + Id));

        course.setTitle(newCourse.getTitle());
        course.setDescription(newCourse.getDescription());

        Teacher teacher = teacherRepository.findById(newCourse.getTeacherId())
                .orElseThrow(() -> new ResourceNotFoundException("cant find teacher by Id: " + newCourse.getTeacherId()));

        if (!teacher.isActive()) {
            throw new ResourceNotFoundException("Cannot assign course to inactive teacher");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);
        var result = mapper.toCourseDto(course);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
