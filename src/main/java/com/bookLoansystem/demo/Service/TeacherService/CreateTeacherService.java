package com.bookLoansystem.demo.Service.TeacherService;

import com.bookLoansystem.demo.DTOs.TeacherDto;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateTeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private Mapper mapper;

    public ResponseEntity<TeacherDto> createTeacher(TeacherDto teacherDto){

        if (teacherRepository.existsByName(teacherDto.getName())) {
            throw new RuntimeException("Teacher already exists: " + teacherDto.getName());
        }

        var teacher = mapper.toTeacherEntity(teacherDto);
        teacherRepository.save(teacher);
        var result = mapper.toTeacherdto(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
