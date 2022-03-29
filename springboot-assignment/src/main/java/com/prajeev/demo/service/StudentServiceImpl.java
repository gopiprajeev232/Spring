package com.prajeev.demo.service;

import com.prajeev.demo.dto.StudentDTO;
import com.prajeev.demo.entity.College;
import com.prajeev.demo.entity.Student;
import com.prajeev.demo.repository.CollegeRepository;
import com.prajeev.demo.repository.StudentRepository;
import javax.persistence.Query;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Student findById(int id) {
        Optional<Student> stu = studentRepository.findById(id);

        Student student = null;

        if(stu.isPresent())
            student = stu.get();

        return student;
    }

    @Override
    public List<Student> findByCollegeId(int collegeId) {
        List<Student> students = studentRepository.findByCollegeId(collegeId);

        return students;
    }

    @Override
    public Student save(Student student, int collegeId) {
        College college = collegeRepository.findById(collegeId).get();
        college.add(student);

        studentRepository.save(student);

        return student;
    }

    @Override
    public void deleteById(int id) {
        System.out.println("ID: "+id);
        studentRepository.deleteById(id);
        List<Student> students = studentRepository.findByCollegeId(1);
    }

    public StudentDTO convertEntityToDto(Student student) {
        StudentDTO studentDTO = mapper.map(student, StudentDTO.class);

        return studentDTO;
    }
}
