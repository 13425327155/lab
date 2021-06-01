package com.example.team.service;

import com.example.team.dao.TeamDao;
import com.example.team.model.Team;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    @Resource
    TeamDao teamDao;

    //检查团队账号密码
    @Override
    public Team teamLogin(String stu_number, String stu_pwd) {
        Team team = teamDao.teamLogin(stu_number,stu_pwd);
        return team;
    }


    @Override
    public void save(Team team) {
        teamDao.save(team);
    }

    @Override
    public List<Team> findByStuNum(String stu_number){
        return teamDao.findByStuNum(stu_number);
    }

    @Override
    public List<Team> viewTeamList() {
        return teamDao.viewTeamList();
    }

    @Override
    public List<Team> searchTeamList(String inputs) {
        return teamDao.searchTeamList(inputs);
    }
}
