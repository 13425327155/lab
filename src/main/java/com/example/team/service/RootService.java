package com.example.team.service;


import com.example.team.model.Root;

public interface RootService {
    //检验账号和密码
    Root checkUser(Root root);

    void updateRoot(Root root);
}
