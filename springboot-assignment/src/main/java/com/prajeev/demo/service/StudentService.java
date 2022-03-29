package com.prajeev.demo.service;

import com.prajeev.demo.dto.StudentDTO;
import com.prajeev.demo.entity.College;
import com.prajeev.demo.entity.Student;
import org.springframework.data.domain.Page;
import java.util.List;

public interface StudentService {
    List<StudentDTO> findAll();
    Student findById(int id);
    Student save(Student student, int collegeId);
    void deleteById(int id);
    List<Student> findByCollegeId(int collegeId);
    StudentDTO convertEntityToDto(Student student);
}
