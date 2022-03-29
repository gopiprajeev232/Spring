package com.prajeev.demo.repository;

import com.prajeev.demo.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClubRepository extends JpaRepository<Club, Integer> {

}
