package com.example.team.controller;

import com.example.team.model.User;
import com.example.team.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserLoginController {

    @Autowired
    UserService userService;

    @PostMapping("/user_login")
    public String login(User user, Map<String, Object> map, HttpServletRequest request){
        User checkuser = userService.checkUser(user);
        HttpSession session = request.getSession();
        if (checkuser != null){
            //存入session中
            request.getSession().setAttribute("userInfo_user", checkuser);
//            System.out.println(session.getAttribute("userInfo"));
            return "user/index";
        }
        else {
            map.put("loginError", "用户名或密码错误，请重新登录！");
            return "user/userLogin";
        }
    }

    @GetMapping("/userLogin")
    public String Achievement(){
        return "user/userLogin";
    }

    @GetMapping("logout_user")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        //移除信息
        session.removeAttribute("userInfo_user");
        return "user/userLogin";
    }

}
