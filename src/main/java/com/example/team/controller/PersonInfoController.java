package com.example.team.controller;

import com.example.team.model.PersonInfo;
import com.example.team.model.Team;
import com.example.team.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class PersonInfoController {

    @Autowired
    private PersonInfoService personInfoService;

    @GetMapping("/studentLogin")
    public String studentLogin(){
        return "student/studentLogin";
    }

    private static Logger logger = LoggerFactory.getLogger(PersonInfoController.class);


    //查找团队成员
    @RequestMapping("/findMember")
    public String findMember(HttpServletRequest servletRequest,Model model){
        HttpSession session = servletRequest.getSession();
        Team w = (Team) session.getAttribute("teamInfo");
        //获取登录的团队编号
        String team_id = String.valueOf(w.getId());
        //获取姓名
        String mem_name = servletRequest.getParameter("search");

        List<PersonInfo> personInfo = personInfoService.findByName(team_id,mem_name);
        model.addAttribute("personInfos",personInfo);
        return "managingMembers";
    }

    //显示团队所有成员
    @RequestMapping("/managingMembers")
    public String findMembers(HttpServletRequest servletRequest,Model model){
        HttpSession session = servletRequest.getSession();
        Team w = (Team) session.getAttribute("teamInfo");
        //获取登录的团队编号
        String team_id = String.valueOf(w.getId());

        List<PersonInfo> personInfo = personInfoService.findByTeamId(team_id);
        model.addAttribute("personInfos",personInfo);
        return "managingMembers";
    }

    //从团队中删除成员
    @GetMapping("/deleteMembers")
    public String deleteMembers(int id){
        personInfoService.deleteMember(id);
        return "redirect:/managingMembers";
    }

    //招新
    @RequestMapping("/recruit")
    public String findNew(HttpServletRequest servletRequest,Model model){
        HttpSession session = servletRequest.getSession();
        Team w = (Team) session.getAttribute("teamInfo");
        //获取登录的团队编号
        String team_id = String.valueOf(w.getId());

        List<PersonInfo> personNew = personInfoService.findNew(team_id);
        model.addAttribute("personNews",personNew);
        return "recruit";
    }
    //同意招新
    @GetMapping("/agree")
    public String agree(int id){
        personInfoService.agree(id);
        return "redirect:/recruit";
    }
    //拒绝申请
    @GetMapping("/refuse")
    public String refuse(int id){
        personInfoService.refuse(id);
        return "redirect:/recruit";
    }

    @RequestMapping("/findPersonInfo")
    public String findPersonInfo(String stu_number, Model model){
        PersonInfo personInfo = personInfoService.findPersonInfo(stu_number);
        model.addAttribute("personInfo", personInfo);
        return "student/personInfo";
    }

    @RequestMapping("/savePersonInfo")
    public String savePersonInfo(String stu_number, PersonInfo personInfo){
        personInfoService.savePersonInfo(stu_number, personInfo);
        return "student/personInfo";
    }

    @RequestMapping("/toUpdatePassword")
    public String toUpdatePassword(){
        return "student/updatePassword";
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public String updatePassword(String oldPwd, String newPwd, String reSure, HttpServletRequest request){
        HttpSession session = request.getSession();
        PersonInfo personInfo = (PersonInfo) session.getAttribute("personInfo");
        String msg = personInfoService.updatePassword(personInfo.getStu_number(), oldPwd, newPwd, reSure);
        return msg;
    }
}
