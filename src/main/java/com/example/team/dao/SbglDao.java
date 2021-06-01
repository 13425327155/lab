package com.example.team.dao;



import com.example.team.model.Sbgl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SbglDao extends JpaRepository<Sbgl, Long> {

    Sbgl findById(long id);

    void deleteById(Long id);

    List<Sbgl> findByName(String Name);
}