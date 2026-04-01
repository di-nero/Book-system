package com.bookLoansystem.demo.DTOs;

import com.bookLoansystem.demo.Entity.StudentProfile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class StudentProfileDto {

    private Long Id;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{11}$", message = "Phone number must be 11 digits")
    private String phoneNumber;

    @NotBlank(message = "address is required")
    private String address;

   public StudentProfileDto(StudentProfile studentProfile){
       this.address = studentProfile.getAddress();
       this.phoneNumber = studentProfile.getPhoneNumber();
       this.Id = studentProfile.getId();
       this.dateOfBirth = studentProfile.getDateOfBirth();
   }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public StudentProfileDto() {
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
}
