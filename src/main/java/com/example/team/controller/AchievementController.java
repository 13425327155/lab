package com.example.team.controller;

import com.example.team.model.Achievement;

import com.example.team.service.AchievementService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AchievementController {

    //成果汇报
    @Autowired
    private AchievementService achievementService;

    //添加成果
    @PostMapping("/achievement")
    public String addAchievement(Achievement achievement){
        achievementService.save(achievement);
        return "achievement";
    }

    //查询所有成果
    @RequestMapping("/queryAchievements")
    public String findAll(Model model){
        List<Achievement> achievement = achievementService.findAll();
        model.addAttribute("achievements",achievement);
        return "queryAchievements";
    }


    @GetMapping("/achievement")
    public String Achievement(){
        return "root/achievement";
    }

    @GetMapping("/achievement2")
    public String Achievement2(){
        return "achievement";
    }

    /**
     * 分页查询数据
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findByAchievementPage")
    public String findByAchievementPage(Model model,
                                        @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                                        @RequestParam(defaultValue="5",value="pageSize")Integer pageSize){
        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //设置默认每页显示的数据数
        }

        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum,pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        try {
            List<Achievement> achievementList = achievementService.findAll();
            //3.使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
            PageInfo<Achievement> pageInfo = new PageInfo<Achievement>(achievementList,pageSize);
            //4.使用model/map/modelandview等带回前端
            model.addAttribute("achieves",achievementList);
            model.addAttribute("pageInfo",pageInfo);
        }finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }
        //5.设置返回的jsp/html等前端页面
        // thymeleaf默认就会拼串classpath:/templates/xxxx.html
        return "root/achievement";
    }


    /**
     * 根据成果名称查询
     * @param request
     * @param model
     * @return
     */
    @GetMapping("/searchAchieveByName")
    public String searchAchieveByName(HttpServletRequest request, Model model){
        //获取搜索框的值
        String searchword = request.getParameter("search_name");
        //根据号码查询的信息
        List<Achievement> search_achieve = achievementService.searchAchieveByName(searchword);
        //将信息返回给页面
        model.addAttribute("achieves",search_achieve);
        return "root/achievement";
    }


    /**
     * 添加
     * @param achievement
     * @param model
     * @return
     */
    @PostMapping("/addAchieve")
    public String addAchieve(Achievement achievement,Model model){
        //保存信息
        achievementService.insert(achievement);
        //重定向到列表页面
        return "redirect:/findByAchievementPage";
    }


    /**
     * 跳转去更新页面，数据回显
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/toupdateAchieve/{id}")
    public String toupdateAchieve(@PathVariable("id") Integer id, Model model){
        Achievement achievement = achievementService.findByAchieveId(id);
        model.addAttribute("updateAchieveDate",achievement);
        return "root/updateAchieve";
    }

    /**
     * 更新
     * @param achievement
     * @param model
     * @return
     */
    @PostMapping("/updateAchieve2")
    public String updateAchieve(Achievement achievement,Model model){
        //保存信息
        System.out.println(achievement);
        achievementService.updateAchieve(achievement);
        //重定向到列表页面
        return "redirect:/findByAchievementPage";
    }


    @GetMapping("/delAchieve/{id}")
    public String delAchieve(@PathVariable("id") Integer id ){
        achievementService.delAchieveById(id);
        return "redirect:/findByAchievementPage";
    }



}

