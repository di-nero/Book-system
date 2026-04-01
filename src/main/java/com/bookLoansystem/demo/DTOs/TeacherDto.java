package com.bookLoansystem.demo.DTOs;

import com.bookLoansystem.demo.Entity.Teacher;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;
import java.util.stream.Collectors;

public class TeacherDto {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "subject is required")
    private String subject;

    private Set<CourseDto> course;

    private boolean active = true;



    public TeacherDto(Teacher teacher){

        this.id = teacher.getId();

        this.name = teacher.getName();

        this.subject = teacher.getSubject();

        this.course = teacher.getCourses().stream().map(CourseDto::new).collect(Collectors.toSet());

        this.active = teacher.isActive();
    }

    public TeacherDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<CourseDto> getCourse() {
        return course;
    }

    public void setCourse(Set<CourseDto> course) {
        this.course = course;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
