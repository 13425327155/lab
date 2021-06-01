package com.example.team.service;

import com.example.team.model.CheckIn;

import java.util.List;

public interface CheckInService {
    void save(CheckIn checkIn);
    List<CheckIn> findAllCheckIn();
    CheckIn findByCheckInId(Integer id);
    void delCheckInById(Integer id);
    List<CheckIn> searchCheckInByName(String searchword);
    void insert(CheckIn checkin);
    void updateByPrimaryKey(CheckIn checkin);
}
