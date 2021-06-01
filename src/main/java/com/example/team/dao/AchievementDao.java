package com.example.team.dao;

import com.example.team.model.Achievement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AchievementDao {

    List<Achievement> findAll();

    void save(Achievement achievement);

    List<Achievement> findAllAchieve();

    List<Achievement> searchAchieveByName(@Param("searchword") String searchword);

    void insert(Achievement achievement);

    Achievement findByAchieveId(Integer id);

    void delAchieveById(Integer id);

    void updateAchieve(Achievement achievement);
}
