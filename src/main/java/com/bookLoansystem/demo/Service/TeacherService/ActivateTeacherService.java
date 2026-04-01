package com.bookLoansystem.demo.Service.TeacherService;


import com.bookLoansystem.demo.DTOs.TeacherDto;
import com.bookLoansystem.demo.Entity.Teacher;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ActivateTeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private Mapper mapper;

    public ResponseEntity<TeacherDto> activateTeacher(Long id) {

        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("cant find teacher with id: " + id));

        if (teacher.isActive()) {
            throw new RuntimeException("Teacher is already active");
        }

        teacher.setActive(true);
        teacherRepository.save(teacher);
        var result = mapper.toTeacherdto(teacher);
        return ResponseEntity.ok(result);
    }
}
