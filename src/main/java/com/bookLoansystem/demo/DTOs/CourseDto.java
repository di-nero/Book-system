package com.bookLoansystem.demo.DTOs;

import com.bookLoansystem.demo.Entity.Course;
import com.bookLoansystem.demo.Entity.Student;
import com.bookLoansystem.demo.Entity.Teacher;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class CourseDto {

    private Long id;

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "teacher's name is required")
    private String teacherName;

    @NotBlank(message = "teacher's ID is required")
    private Long teacherId;


    public CourseDto(Course course){

        this.id = course.getId();

        this.title = course.getTitle();

        this.description = course.getDescription();

        this.teacherName = course.getTeacher() != null
                ? course.getTeacher().getName()
                : "No teacher assigned";
        this.teacherId = course.getTeacher() != null
                ? course.getTeacher().getId()
                : null;

    }

    public CourseDto() {
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
