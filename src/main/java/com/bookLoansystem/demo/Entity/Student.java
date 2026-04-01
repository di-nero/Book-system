package com.bookLoansystem.demo.Entity;


import com.bookLoansystem.demo.DTOs.StudentDto;
import com.bookLoansystem.demo.DTOs.StudentProfileDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private StudentProfile studentProfile;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_course",
            joinColumns        = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    ) //owner of the relationship
    private Set<Course> courses = new HashSet<>();

    public Student(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.studentProfile = student.getStudentProfile();
        this.courses = student.getCourses();
    }

    public Student(StudentDto studentDto){
        this.id = studentDto.getId();
        this.name = studentDto.getName();
        this.email = studentDto.getEmail();

        this.studentProfile = studentDto.getStudentProfile() != null
                ? new StudentProfile(studentDto.getStudentProfile())
                : null;

        this.courses = studentDto.getCourse() != null
                ? studentDto.getCourse()
                .stream()
                .map(Course::new)
                .collect(Collectors.toSet())
                : new HashSet<>();
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
