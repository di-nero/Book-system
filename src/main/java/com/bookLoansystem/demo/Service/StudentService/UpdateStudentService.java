package com.bookLoansystem.demo.Service.StudentService;


import com.bookLoansystem.demo.DTOs.StudentDto;
import com.bookLoansystem.demo.Entity.Student;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private Mapper mapper;

    @Transactional
    public StudentDto updateStudent(Long id, StudentDto newStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        if (studentRepository.existsByEmailAndIdNot(newStudent.getEmail(), id)) {
            throw new RuntimeException("Email already exists: " + newStudent.getEmail());
        }

        student.setName(newStudent.getName());
        student.setEmail(newStudent.getEmail());

        // ✅ Update profile fields here, before saving
        if (student.getStudentProfile() != null && newStudent.getStudentProfile() != null) {
            student.getStudentProfile().setDateOfBirth(newStudent.getStudentProfile().getDateOfBirth());
            student.getStudentProfile().setAddress(newStudent.getStudentProfile().getAddress());
            student.getStudentProfile().setPhoneNumber(newStudent.getStudentProfile().getPhoneNumber());
        }

        studentRepository.save(student);
        return mapper.toStudentDto(student);
    }
}
