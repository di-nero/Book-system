package com.bookLoansystem.demo.DTOs;

import com.bookLoansystem.demo.Entity.Student;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Set;
import java.util.stream.Collectors;

public class StudentDto {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "email is required")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Invalid email format"
    )
    private String email;

    @Valid
    private StudentProfileDto studentProfile;

    private Set<CourseDto> course;

    public StudentDto(Student student){

        this.id = student.getId();

        this.name = student.getName();

        this.email = student.getEmail();

        this.studentProfile = student
                .getStudentProfile() != null ? new StudentProfileDto(student
                .getStudentProfile()) : null;

        this.course = student.getCourses().stream().map((CourseDto::new)).collect(Collectors.toSet());
    }

    public StudentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudentProfileDto getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfileDto studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Set<CourseDto> getCourse() {
        return course;
    }

    public void setCourse(Set<CourseDto> course) {
        this.course = course;
    }
}
