package com.example.team.dao;

import com.example.team.model.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplyDao {
    //提交申请表
    void save(Apply apply);

    //查看以往申请
    List<Apply> findAll(@Param("team_name") String team_name);

    List<Apply> findAllApply();

    List<Apply> searchApplyByName(String searchword);

    List<Apply> searchApplyByState(String apply_state);

    Apply findApplyById(String id);

    void updateApply(Apply apply);

}
