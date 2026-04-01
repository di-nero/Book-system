package com.bookLoansystem.demo.Entity;

import com.bookLoansystem.demo.DTOs.StudentProfileDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOfBirth;

    private String phoneNumber;

    private String address;

    @OneToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    public StudentProfile(StudentProfile studentProfile){

        this.id = studentProfile.getId();
        this.dateOfBirth = studentProfile.getDateOfBirth();
        this.phoneNumber = studentProfile.getPhoneNumber();
        this.address = studentProfile.getAddress();
        this.student = studentProfile.getStudent();

    }

    public StudentProfile(StudentProfileDto studentProfileDto) {

        this.id = studentProfileDto.getId();
        this.dateOfBirth = studentProfileDto.getDateOfBirth();
        this.phoneNumber = studentProfileDto.getPhoneNumber();
        this.address = studentProfileDto.getAddress();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
