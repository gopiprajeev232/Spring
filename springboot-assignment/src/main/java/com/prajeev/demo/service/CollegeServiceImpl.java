package com.prajeev.demo.service;

import com.prajeev.demo.dto.CollegeDTO;
import com.prajeev.demo.entity.College;
import com.prajeev.demo.repository.CollegeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private ModelMapper mapper;

    private CollegeRepository collegeRepository;

    @Autowired
    public CollegeServiceImpl(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @Override
    public List<CollegeDTO> findAll() {
        return collegeRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public College findById(int id) {
        return collegeRepository.findById(id).get();
    }

    @Override
    public College save(College college) {
        collegeRepository.save(college);
        return college;
    }

    @Override
    public void deleteById(int id) {
        collegeRepository.deleteById(id);
    }

    public CollegeDTO convertEntityToDTO(College college) {
        return mapper.map(college, CollegeDTO.class);
    }
}
