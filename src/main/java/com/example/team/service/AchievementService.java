package com.example.team.service;

import com.example.team.model.Achievement;

import java.util.List;

public interface AchievementService {

    List<Achievement> findAll();

    void save(Achievement achievement);


    List<Achievement> findAllAchieve();

    List<Achievement> searchAchieveByName(String searchword);

    void insert(Achievement achievement);

    Achievement findByAchieveId(Integer id);

    void delAchieveById(Integer id);

    void updateAchieve(Achievement achievement);
}
