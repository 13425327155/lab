package com.example.team.controller;

import com.example.team.model.PersonInfo;
import com.example.team.service.PersonInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    private PersonInfoService personInfoService;

    @RequestMapping("/stu_login")
    public String stu_login(PersonInfo personInfo, Map<String, Object> map, HttpServletRequest request){
        boolean flag = personInfoService.loginPersonInfo(personInfo.getStu_number(), personInfo.getStu_password());
        if (flag){
            PersonInfo person = personInfoService.findByStuNum(personInfo.getStu_number());
            //登陆成功利用session存储学号和密码，转到学生管理页面
            HttpSession session = request.getSession(true);
            session.setAttribute("personInfo", person);
            return "student/student_index";
        }else{
            map.put("loginError", "用户名或密码错误，请重新登录！");
            return "student/studentLogin";
        }
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "student/studentLogin";
    }

    @RequestMapping("/unLogin")
    public String unLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("personInfo");
        return "student/studentLogin";
    }
}
