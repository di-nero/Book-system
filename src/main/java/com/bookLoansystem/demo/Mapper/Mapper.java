package com.bookLoansystem.demo.Mapper;

import com.bookLoansystem.demo.DTOs.*;
import com.bookLoansystem.demo.Entity.Course;
import com.bookLoansystem.demo.Entity.Student;
import com.bookLoansystem.demo.Entity.StudentProfile;
import com.bookLoansystem.demo.Entity.Teacher;
import org.springframework.stereotype.Component;


@Component
public class Mapper {

    public StudentDto toStudentDto(Student student){
        return new StudentDto(student);
    }

    public Student toStudentEntity(StudentDto studentDto){
        return new Student(studentDto);
    }

    public CourseDto toCourseDto(Course course){
        return new CourseDto(course);
    }

    public Course toCourseEntity(CourseDto courseDto){
        return new Course(courseDto);
    }

    public TeacherDto toTeacherdto(Teacher teacher){
        return new TeacherDto(teacher);
    }

    public Teacher toTeacherEntity(TeacherDto teacherDto){
        Teacher teacher = new Teacher(teacherDto);
        teacher.setActive(true);
        return teacher;
    }

    public StudentProfileDto toStudentProfileDto(StudentProfile studentProfile){
        return new StudentProfileDto(studentProfile);
    }

    public StudentProfile toStudentProfileEntity(StudentProfileDto studentProfileDto){
        return new StudentProfile(studentProfileDto);
    }

    public StudentCourseDto toStudentCourseDto(Student student){
        return new StudentCourseDto(student);
    }

}
