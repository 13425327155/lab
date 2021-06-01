package com.example.team.service;

import com.example.team.model.PersonInfo;
import java.util.List;


public interface PersonInfoService {

    List<PersonInfo> findByName(String team_id,String mem_name);

    //通过team_id查找属于该团队的人员
    List<PersonInfo> findByTeamId(String team_id);
    //通过修改men_state来删除团队成员
    void deleteMember(int id);

    //招新
    List<PersonInfo> findNew(String team_id);
    //通过招新
    void agree(int id);
    //拒绝申请
    void refuse(int id);

    //通过stu_number查找属于该团队的人员
    PersonInfo findByStuNum(String stu_number);


    String findPersonInfoById(int id);
    boolean loginPersonInfo(String stu_number, String stu_password);
    PersonInfo findPersonInfoId(String stu_number, String stu_password);
    PersonInfo findPersonInfo(String stu_number);
    void savePersonInfo(String stu_number, PersonInfo personInfo);
    String updatePassword(String stu_number, String oldPwd, String newPwd, String reSure);
    //更新状态
    String updateState(String team_id, int id);
    //退出团队
    void deleteMem_state(String stu_number);
}
