package com.example.team.controller;

import com.example.team.model.Sbgl;
import com.example.team.service.SbglService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SbglController {

    @Resource
    SbglService sbglService;



    @RequestMapping("/searchSbgl")
    public String searchAchieveByName(HttpServletRequest request, Model model){
        //获取搜索框的值
        String searchword = request.getParameter("searche");
        //根据号码查询的信息
        List<Sbgl> search_achieve = sbglService.findSbglByname((searchword));
        //将信息返回给页面
        model.addAttribute("achieves",search_achieve);
        return "user/sbgl";
    }
    @RequestMapping("/sbgl")
    public String list(Model model) {
        List<Sbgl> sbgls= sbglService.getSbglList();
        model.addAttribute("sbgls", sbgls);
        return "user/sbgl";
    }

    @RequestMapping("/toSbglAdd")
    public String toSbglAdd() {
        return "user/sbglAdd";
    }

    @RequestMapping("/sbgladd")
    public String add(Sbgl sbgl) {
        sbglService.save(sbgl);
        return "redirect:/sbgl";
    }

    @RequestMapping("/toSbglEdit")
    public String toEdit(Model model, Long id) {
        Sbgl sbgl = sbglService.findSbglById(id);
        model.addAttribute("sbgl", sbgl);
        return "user/sbglEdit";
    }

    @RequestMapping("/sbgledit")
    public String edit(Sbgl sbgl) {
        sbglService.edit(sbgl);
        return "redirect:/sbgl";
    }


    @RequestMapping("/Sbgldelete")
    public String delete(Long id) {
        sbglService.delete(id);
        return "redirect:/sbgl";
    }
}