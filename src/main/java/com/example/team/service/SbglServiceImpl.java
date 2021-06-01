package com.example.team.service;



import com.example.team.dao.SbglDao;
import com.example.team.model.Sbgl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SbglServiceImpl implements SbglService {

    @Autowired
    private SbglDao sbglDao;

    @Override
    public List<Sbgl> getSbglList() {
        return sbglDao.findAll();
    }

    @Override
    public Sbgl findSbglById(long id) {
        return sbglDao.findById(id);
    }

    @Override
    public List<Sbgl> findSbglByname(String name) {
        return sbglDao.findByName(name);
    }




    @Override
    public void save(Sbgl sbgl) {
        sbglDao.save(sbgl);
    }

    @Override
    public void edit(Sbgl sbgl) {
        sbglDao.save(sbgl);
    }

    @Override
    public void delete(long id) {
        sbglDao.deleteById(id);
    }
}


