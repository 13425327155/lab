package com.example.team.service;

import com.example.team.dao.CheckInDao;
import com.example.team.model.CheckIn;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService {

    @Resource
    private CheckInDao checkInDao;

    @Override
    public void save(CheckIn checkIn) {
        checkInDao.save(checkIn);
    }

    @Override
    public List<CheckIn> findAllCheckIn() {
        return checkInDao.findAllCheckIn();
    }

    @Override
    public CheckIn findByCheckInId(Integer id) {
        return checkInDao.findByCheckInId(id);
    }

    @Override
    public void delCheckInById(Integer id) {
        checkInDao.delCheckInById(id);
    }

    @Override
    public List<CheckIn> searchCheckInByName(String searchword) {
        return checkInDao.searchCheckInByName(searchword);
    }


    @Override
    public void insert(CheckIn checkin) {
        checkInDao.insert(checkin);
    }

    @Override
    public void updateByPrimaryKey(CheckIn checkin) {
        checkInDao.updateByPrimaryKey(checkin);
    }
}
