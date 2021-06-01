package com.example.team.controller;

import com.example.team.model.Msgl;
import com.example.team.service.MsglService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MsglController {

    @Resource
    MsglService msglService;



    @RequestMapping("/searchMsgl")
    public String searchAchieveByName(HttpServletRequest request, Model model){
        //获取搜索框的值
        String searchword = request.getParameter("searche");
        //根据号码查询的信息
        List<Msgl> search_achieve = msglService.findMsglByIdentifier((searchword));
        //将信息返回给页面
        model.addAttribute("achieves",search_achieve);
        return "user/msgl";
    }
    @RequestMapping("/msgl")
    public String list(Model model) {
        List<Msgl> msgls= msglService.getMsglList();
        model.addAttribute("msgls", msgls);
        return "user/msgl";
    }

    @RequestMapping("/toMsglAdd")
    public String toMsglAdd() {
        return "user/msglAdd";
    }

    @RequestMapping("/msgladd")
    public String add(Msgl msgl) {
        msglService.save(msgl);
        return "redirect:/msgl";
    }

    @RequestMapping("/toMsglEdit")
    public String toEdit(Model model, Long id) {
        Msgl msgl = msglService.findMsglById(id);
        model.addAttribute("msgl", msgl);
        return "user/msglEdit";
    }

    @RequestMapping("/msgledit")
    public String edit(Msgl msgl) {
        msglService.edit(msgl);
        return "redirect:/msgl";
    }


    @RequestMapping("/Msgldelete")
    public String delete(Long id) {
        msglService.delete(id);
        return "redirect:/msgl";
    }
}