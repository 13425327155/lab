package com.example.team.service;

import com.example.team.model.Team;

import java.util.List;

public interface TeamService {

    //检查团队账号密码
    Team teamLogin(String stu_number, String stu_pwd);


    void save(Team team);

    //查看团队信息
    List<Team> findByStuNum(String stu_number);

    List<Team> viewTeamList();

    List<Team> searchTeamList(String inputs);


}
