package com.example.team.controller;

import com.example.team.model.Achievement;
import com.example.team.model.Apply;
import com.example.team.model.Team;
import com.example.team.service.ApplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    //提交申请表
    @PostMapping("/apply")
    public String apply(Apply apply){
        apply.setApply_state("0");
        apply.setIs_responsibility("1");
        applyService.save(apply);
        return "apply";
    }

    //查询以往申请
    @RequestMapping("/queryApply")
    public String findAll(HttpServletRequest servletRequest,Model model){
        HttpSession session = servletRequest.getSession();
        Team w = (Team) session.getAttribute("teamInfo");
//        System.out.println(w.toString());
        //获取登录的团队名称，再根据团队名称找申请
//        System.out.println(w.getTeam_name());
        List<Apply> apply = applyService.findAll(w.getTeam_name());
//        System.out.println(apply.toString());
        model.addAttribute("applies",apply);
        return "queryApply";
    }

    @GetMapping("/apply")
    public String apply() {
        return "root/apply";
    }

    @GetMapping("/apply2")
    public String apply2() {
        return "apply";
    }

    /**
     * 分页
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findByApplyPage")
    public String findByApplyPage(Model model,
                                  @RequestParam(required = false, defaultValue = "1", value = "pageNum") Integer pageNum,
                                  @RequestParam(defaultValue = "5", value = "pageSize") Integer pageSize) {
        //为了程序的严谨性，判断非空：
        if (pageNum == null) {
            pageNum = 1;   //设置默认当前页
        }
        if (pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;    //设置默认每页显示的数据数
        }

        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum, pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        try {
//            List<Apply> applyList = applyService.findAllApply();
            List<Apply> applyList = applyService.searchApplyByState("0");
            //3.使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
            PageInfo<Apply> pageInfo = new PageInfo<Apply>(applyList, pageSize);
            //4.使用model/map/modelandview等带回前端
            model.addAttribute("applys", applyList);
            model.addAttribute("pageInfo", pageInfo);
        } finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }
        //5.设置返回的jsp/html等前端页面
        // thymeleaf默认就会拼串classpath:/templates/xxxx.html
        return "root/apply";
    }


    /**
     * 根据申请人名称查询
     *
     * @param request
     * @param model
     * @return
     */
    @GetMapping("/searchApplyByName")
    public String searchApplyByName(HttpServletRequest request, Model model) {
        //获取搜索框的值
        String searchword = request.getParameter("search_name");
        //根据号码查询的信息
        List<Apply> search_apply = applyService.searchApplyByName(searchword);
        //将信息返回给页面
        model.addAttribute("applys", search_apply);
        return "root/apply";
    }


    /**
     * 根据申请实验室状态查询
     * @param model
     * @param apply_state
     * @return
     */
    @GetMapping("/searchApplyByState")
    public String searchApplyByState(Model model, @RequestParam("apply_state") String apply_state) {
        List<Apply> search_apply = applyService.searchApplyByState(apply_state);
        //将信息返回给页面
        System.out.println(search_apply.toArray());
        model.addAttribute("applys", search_apply);
        return "root/apply";
    }

    @RequestMapping("/updateApplyState/{id}/{state}")
    public String updateApplyState(@PathVariable("id") String id, @PathVariable("state") String state){
        System.out.println(id + "  :  "+ state);
        Apply apply = applyService.findApplyById(id);
        apply.setApply_state(state);
        System.out.println(apply);
        applyService.updateApply(apply);
        return "redirect:/findByApplyPage";
    }
}
