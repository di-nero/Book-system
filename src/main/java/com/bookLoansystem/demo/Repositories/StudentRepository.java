package com.bookLoansystem.demo.Repositories;

import com.bookLoansystem.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findById(Long Id);

    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id);
}
