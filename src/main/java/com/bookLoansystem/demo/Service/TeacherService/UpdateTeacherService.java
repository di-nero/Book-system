package com.bookLoansystem.demo.Service.TeacherService;


import com.bookLoansystem.demo.DTOs.TeacherDto;
import com.bookLoansystem.demo.Entity.Teacher;
import com.bookLoansystem.demo.Exception.ResourceNotFoundException;
import com.bookLoansystem.demo.Mapper.Mapper;
import com.bookLoansystem.demo.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UpdateTeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private Mapper mapper;

    public ResponseEntity<TeacherDto> updateTeacher(Long Id , TeacherDto newTeacher){

        Teacher teacher = teacherRepository
                .findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("cant find Teacher by id: " + Id));

        teacher.setName(newTeacher.getName());
        teacher.setSubject(newTeacher.getSubject());

        teacherRepository.save(teacher);

        var result = mapper.toTeacherdto(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
