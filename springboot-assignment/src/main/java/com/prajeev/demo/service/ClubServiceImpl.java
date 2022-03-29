package com.prajeev.demo.service;

import com.prajeev.demo.dto.ClubDTO;
import com.prajeev.demo.entity.Club;
import com.prajeev.demo.repository.ClubRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public List<ClubDTO> findAll() {
        return clubRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Club findById(int id) {
        return clubRepository.findById(id).get();
    }

    @Override
    public Club save(Club club) {
        clubRepository.save(club);
        return club;
    }

    @Override
    public void deleteById(int id) {
        clubRepository.deleteById(id);
    }

    public ClubDTO convertEntityToDto(Club club) {
        return mapper.map(club, ClubDTO.class);
    }
}
