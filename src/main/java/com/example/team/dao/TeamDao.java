package com.example.team.dao;

import com.example.team.model.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeamDao {

    //团队登录
    Team teamLogin(@Param("stu_number") String stu_number,@Param("stu_pwd") String stu_pwd);

    void save(Team team);

    //通过账号查找
    List<Team> findByStuNum(@Param("stu_number") String stu_number);

    //查看团队列表
    List<Team> viewTeamList();

    List<Team> searchTeamList(@Param("inputs") String inputs);
}
