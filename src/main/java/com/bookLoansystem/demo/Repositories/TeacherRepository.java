package com.bookLoansystem.demo.Repositories;
import com.bookLoansystem.demo.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher , Long> {

    Optional<Teacher> findById(Long id);

    boolean existsByName(String name);
}
