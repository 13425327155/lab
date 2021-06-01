package com.example.team.controller;

import com.example.team.model.Root;
import com.example.team.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class RootController {

    @Autowired
    RootService rootService;

    /**
     * 登录
     * @param root
     * @param request
     * @return
     */
    @PostMapping("/login")
    public String login(Root root, Map<String,Object> map, HttpServletRequest request){
        Root checkroot = rootService.checkUser(root);
        HttpSession session = request.getSession();
        if (checkroot != null){
            //存入session中
            request.getSession().setAttribute("userInfo", checkroot);
//            System.out.println(session.getAttribute("userInfo"));
            return "root/root_index";
        }
        else {
            map.put("loginError", "用户名或密码错误，请重新登录！");
            return "root/rootLogin";
        }
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        //移除信息
        session.removeAttribute("userInfo");
        return "root/rootLogin";
    }


    @PostMapping("/updateRoot")
    public String updateRoot(Root root,HttpServletRequest request){
        HttpSession session = request.getSession();
        Root root1 = (Root) session.getAttribute("userInfo");
        root.setId(root1.getId());
        root.setRoot_password(root1.getRoot_password());
        rootService.updateRoot(root);
        return "redirect:/root_home";
    }

    @GetMapping("/root_home")
    public String home(){
        return "root/root_index";
    }

    @GetMapping("/root_info")
    public String root_info(){
        return "root/root_info";
    }


    @RequestMapping("/customermanage")
    public String syscustomerShow(){
        return "syscustomerShow";
    }



}
