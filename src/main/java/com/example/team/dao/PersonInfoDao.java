package com.example.team.dao;

import com.example.team.model.PersonInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonInfoDao {

    //通过stu_number查找属于该团队的人员
    PersonInfo findByStuNum(@Param("stu_number") String stu_number);

    List<PersonInfo> findByName(@Param("team_id") String team_id,@Param("mem_name") String mem_name);

    //通过team_id查找属于该团队的人员
    List<PersonInfo> findByTeamId(@Param("team_id") String team_id);
    //通过修改men_state来删除团队成员
    void deleteMember(@Param("id") int id);

    //招新
    List<PersonInfo> findNew(@Param("team_id") String team_id);
    //通过招新
    void agree(@Param("id") int id);
    //拒绝申请
    void refuse(@Param("id") int id);

    PersonInfo findPersonInfoById(@Param("id") int id);
    PersonInfo findPersonInfo(@Param("stu_number")String stu_number);
    PersonInfo findPersonInfoId(@Param("stu_number")String stu_number, @Param("stu_password")String stu_password);
    void savePersonInfo(PersonInfo personInfo);
    void updatePassword(@Param("stu_number")String stu_number, @Param("stu_password")String stu_password);
    //更新状态
    void updateState(@Param("team_id")String team_id, @Param("id") int id);
    //    boolean findPersonInfoMem_stateById(@Param("id")int id);
    //退出团队
    void deleteMem_state(@Param("stu_number")String stu_number);
}
