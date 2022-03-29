package com.prajeev.demo.repository;

import com.prajeev.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByOrderByCollegeIdAsc();

    List<Student> findByCollegeId(int collegeId);
}
