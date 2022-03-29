package com.prajeev.demo.dto;

import com.prajeev.demo.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class CollegeDTO {
    private String id;
    private String collegeName;
    private String collegeLocation;
    private List<Student> students;
}
