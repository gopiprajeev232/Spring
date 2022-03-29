package com.prajeev.demo.service;

import com.prajeev.demo.dto.ClubDTO;
import com.prajeev.demo.entity.Club;

import java.util.List;

public interface ClubService {
    public List<ClubDTO> findAll();
    public Club findById(int id);
    public Club save(Club club);
    public void deleteById(int id);
}
