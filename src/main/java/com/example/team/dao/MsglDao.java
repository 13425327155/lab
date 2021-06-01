package com.example.team.dao;


import com.example.team.model.Msgl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MsglDao extends JpaRepository<Msgl, Long> {

    Msgl findById(long id);

    void deleteById(Long id);

    List<Msgl> findByIdentifier(String identifier);
}