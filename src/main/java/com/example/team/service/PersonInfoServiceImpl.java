package com.example.team.service;

import com.example.team.dao.PersonInfoDao;
import com.example.team.model.PersonInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    @Resource
    PersonInfoDao personInfoDao;

    @Override
    public List<PersonInfo> findByName(String team_id, String mem_name) {
        return personInfoDao.findByName(team_id,mem_name);
    }

    @Override
    public PersonInfo findByStuNum(String stu_number){
        return personInfoDao.findByStuNum(stu_number);
    }

    @Override
    public List<PersonInfo> findByTeamId(String team_id) {
        return personInfoDao.findByTeamId(team_id);
    }

    @Override
    public void deleteMember(int id) {
        personInfoDao.deleteMember(id);
    }

    @Override
    public List<PersonInfo> findNew(String team_id) {
        return personInfoDao.findNew(team_id);
    }

    @Override
    public void agree(int id) {
        personInfoDao.agree(id);
    }

    @Override
    public void refuse(int id) {
        personInfoDao.refuse(id);
    }

    @Override
    public String findPersonInfoById(int id){
        PersonInfo personInfo = personInfoDao.findPersonInfoById(id);
        return personInfo.getMem_state();
    }

    @Override
    public boolean loginPersonInfo(String stu_number, String stu_password) {
        //从数据库找到有关于stu_number的数据
        PersonInfo personInfo = personInfoDao.findPersonInfo(stu_number);
        //进行判断是否符合登录要求
        if (!stu_number.equals("") && !stu_password.equals("") && personInfo.getStu_number().equals(stu_number) && personInfo.getStu_password().equals(stu_password)){
            return true;
        }else return false;
    }

    @Override
    public PersonInfo findPersonInfoId(String stu_number, String stu_password) {
        return personInfoDao.findPersonInfoId(stu_number, stu_password);
    }

    @Override
    public PersonInfo findPersonInfo(String stu_number) {
        PersonInfo personInfo = personInfoDao.findPersonInfo(stu_number);
        return personInfo;
    }

    @Override
    public void savePersonInfo(String stu_number, PersonInfo personInfo) {
        PersonInfo personInfo1 = personInfoDao.findPersonInfo(stu_number);
        personInfo.setId(personInfo1.getId());
        personInfo.setStu_number(personInfo1.getStu_number());
        personInfo.setTeam_id(personInfo1.getTeam_id());
        personInfo.setMem_state(personInfo1.getMem_state());
        personInfoDao.savePersonInfo(personInfo);
    }

    @Override
    public String updatePassword(String stu_number, String oldPwd, String newPwd, String reSure) {
        PersonInfo personInfo = personInfoDao.findPersonInfo(stu_number);
        if (oldPwd == "" || newPwd == "" || reSure == ""){
            return "密码不能为空!";
        }else {
            if (personInfo.getStu_password().equals(oldPwd) && newPwd.equals(reSure)){
                personInfoDao.updatePassword(stu_number, newPwd);
                return "密码修改成功!";
            }else if (!personInfo.getStu_password().equals(oldPwd)){
                return "原密码错误，请重新输入!";
            }else {
                return "新密码不一致，请重新输入!";
            }
        }
    }

    @Override
    public String updateState(String team_id, int id) {
        PersonInfo personInfo = personInfoDao.findPersonInfoById(id);
        //判断是否有团队
        if (personInfo.getMem_state().equals("1")){
            return "不能修改";
        }else {
            personInfoDao.updateState(team_id, id);
            return "可以修改";
        }
    }

    @Override
    public void deleteMem_state(String stu_number) {
        personInfoDao.deleteMem_state(stu_number);
    }


}
