package com.example.team.service;

import com.example.team.dao.MsglDao;
import com.example.team.model.Msgl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsglServiceImpl implements MsglService {

    @Autowired
    private MsglDao msglDao;

    @Override
    public List<Msgl> getMsglList() {
        return msglDao.findAll();
    }

    @Override
    public Msgl findMsglById(long id) {
        return msglDao.findById(id);
    }
    public List<Msgl> findMsglByIdentifier(String identifier) {
        return msglDao.findByIdentifier(identifier);
    }

    @Override
    public void save(Msgl msgl) {
        msglDao.save(msgl);
}

    @Override
    public void edit(Msgl msgl) {
        msglDao.save(msgl);
    }

    @Override
    public void delete(long id) {
        msglDao.deleteById(id);
    }
}


