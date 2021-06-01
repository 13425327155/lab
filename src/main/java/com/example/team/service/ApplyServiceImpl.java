package com.example.team.service;

import com.example.team.dao.ApplyDao;
import com.example.team.model.Apply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Resource
    ApplyDao applyDao;
    @Override
    public void save(Apply apply) {
        applyDao.save(apply);
    }

    @Override
    public List<Apply> findAll(String team_name) {
        return applyDao.findAll(team_name);
    }

    @Override
    public List<Apply> findAllApply() {
        return applyDao.findAllApply();
    }

    @Override
    public List<Apply> searchApplyByName(String searchword) {
        return applyDao.searchApplyByName(searchword);
    }

    @Override
    public List<Apply> searchApplyByState(String apply_state) {
        return applyDao.searchApplyByState(apply_state);
    }

    @Override
    public Apply findApplyById(String id) {
        return applyDao.findApplyById(id);
    }

    @Override
    public void updateApply(Apply apply) {
        applyDao.updateApply(apply);
    }
}
