package com.example.team.dao;


import com.example.team.model.Root;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RootDao {
    //查找用户
    Root findByUsername(@Param("root_name") String root_name);

    void updateRoot(Root root);

}
