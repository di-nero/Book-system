package com.bookLoansystem.demo.Entity;
import com.bookLoansystem.demo.DTOs.TeacherDto;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;



@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String subject;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Course> courses = new HashSet<>();

    @Column
    private boolean active = true;

    public Teacher(Teacher teacher){
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.subject = teacher.getSubject();
        this.courses = teacher.getCourses();
        this.active = teacher.isActive();
    }

    public Teacher(TeacherDto teacherDto) {
        this.id = teacherDto.getId();
        this.name = teacherDto.getName();
        this.subject = teacherDto.getSubject();

        this.courses = teacherDto.getCourse() == null
                ? new HashSet<>()
                : teacherDto.getCourse()
                .stream()
                .map(Course::new)
                .collect(Collectors.toSet());
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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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
