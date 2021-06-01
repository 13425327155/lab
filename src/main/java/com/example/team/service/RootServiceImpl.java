package com.example.team.service;

import com.example.team.dao.RootDao;
import com.example.team.model.Root;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RootServiceImpl implements RootService {

    @Resource
    private RootDao rootDao;

    /**
     * 检验用户
     * @param root
     * @return
     */
    @Override
    public Root checkUser(Root root) {
        Root rootDB = rootDao.findByUsername(root.getRoot_name());
        if (rootDB != null){
            if (rootDB.getRoot_password().equals(root.getRoot_password())){
                return rootDB;
            }
        }
        return null;
    }



    @Override
    public void updateRoot(Root root) {
        rootDao.updateRoot(root);
    }
}
