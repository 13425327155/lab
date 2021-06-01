package com.example.team.service;

import com.example.team.model.Apply;

import java.util.List;

public interface ApplyService {
    //提交申请表
    void save(Apply apply);

    //查看以往申请
    List<Apply> findAll(String team_name);

    List<Apply> findAllApply();

    List<Apply> searchApplyByName(String searchword);

    List<Apply> searchApplyByState(String apply_state);

    Apply findApplyById(String id);

    void updateApply(Apply apply);
}
