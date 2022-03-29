package com.prajeev.demo.service;

import com.prajeev.demo.dto.CollegeDTO;
import com.prajeev.demo.entity.College;

import java.util.List;

public interface CollegeService {
    public List<CollegeDTO> findAll();
    public College findById(int id);
    public College save(College college);
    public void deleteById(int id);
}
