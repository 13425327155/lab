package com.example.team.service;

import com.example.team.dao.AchievementDao;
import com.example.team.model.Achievement;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Resource
    private AchievementDao achievementDao;


    @Override
    public List<Achievement> findAll() {
        return achievementDao.findAll();
    }

    @Override
    public void save(Achievement achievement) {
         achievementDao.save(achievement);
    }


    @Override
    public List<Achievement> findAllAchieve() {
        return achievementDao.findAllAchieve();
    }

    @Override
    public List<Achievement> searchAchieveByName(String searchword) {
        return achievementDao.searchAchieveByName(searchword);
    }

    @Override
    public void insert(Achievement achievement) {
        achievementDao.insert(achievement);
    }

    @Override
    public Achievement findByAchieveId(Integer id) {
        return achievementDao.findByAchieveId(id);
    }

    @Override
    public void delAchieveById(Integer id) {
        achievementDao.delAchieveById(id);
    }

    @Override
    public void updateAchieve(Achievement achievement) {
        achievementDao.updateAchieve(achievement);
    }
}
