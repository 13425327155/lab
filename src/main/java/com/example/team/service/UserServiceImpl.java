package com.example.team.service;

import com.example.team.dao.UserDao;
import com.example.team.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;
    @Override
    public User checkUser(User user) {
        User rootDB = userDao.findByUsername(user.getCapital_number());
        if (rootDB != null){
            if (rootDB.getPassword().equals(user.getPassword())){
                return rootDB;
            }
        }
        return null;
    }
}
