package com.example.team.dao;

import com.example.team.model.CheckIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckInDao {
    void save(CheckIn checkIn);
    CheckIn findByCheckInId(@Param("id") Integer id);
    void delCheckInById(Integer id);
    List<CheckIn> searchCheckInByName(@Param("name") String name);
    List<CheckIn> findAllCheckIn();
    int insert(CheckIn record);
    int updateByPrimaryKey(CheckIn record);
}
