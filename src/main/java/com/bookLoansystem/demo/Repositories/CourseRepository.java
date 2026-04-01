package com.bookLoansystem.demo.Repositories;

import com.bookLoansystem.demo.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findById(Long Id);

    boolean existsByTitle(String title);
}
