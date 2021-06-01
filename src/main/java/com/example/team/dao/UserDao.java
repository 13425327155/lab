package com.example.team.dao;

import com.example.team.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    User findByUsername(@Param("capital_number") String capital_number);
}
