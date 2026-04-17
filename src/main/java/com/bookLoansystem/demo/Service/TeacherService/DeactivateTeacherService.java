package com.bookLoansystem.demo.Service.TeacherService;


import com.bookLoansystem.demo.Entity.Teacher;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DeactivateTeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private Mapper mapper;

    @Transactional
    public ResponseEntity<String> deactivateTeacher(Long Id){

        //check if teacher exists
        Teacher teacher = teacherRepository
                .findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("cant find Teacher by id: " + Id));

        if (!teacher.isActive()) {
            throw new RuntimeException("Teacher is already inactive");
        }

        //Deactivate teacher
        teacher.setActive(false);

        //save in repository
        teacherRepository.save(teacher);

        return ResponseEntity.status(HttpStatus.OK).body("teacher deactivated successfully");
    }

}
