package com.bookLoansystem.demo.DTOs;

import com.bookLoansystem.demo.Entity.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentCourseDto {

    public Long studentId;

    public String studentName;

    public List<CourseDto> courses;

    public StudentCourseDto(Student student) {
        this.studentId = student.getId();
        this.studentName = student.getName();
        this.courses = student.getCourses().stream()
                .map(CourseDto::new)
                .collect(Collectors.toList());
    }

    public StudentCourseDto() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }
}
