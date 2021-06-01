package com.example.team.controller;

import com.example.team.model.CheckIn;
import com.example.team.service.CheckInService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    //添加出入登记
    @PostMapping("/checkIn")
    public String addAchievement(CheckIn checkIn){
        checkInService.save(checkIn);
        return "checkIn";
    }

    @GetMapping("/checkIn2")
    public String checkIn2(){
        return "checkIn";
    }

    /**
     * 查询所有出入人员
     * @param model
     * @return
     */
    @GetMapping("/checkIn")
    public String checkIn(Model model){
        List<CheckIn> checkinList = checkInService.findAllCheckIn();
        model.addAttribute("checkins",checkinList);
        return "root/check_in";
    }

    /**
     * 删除记录
     * @param id
     * @return
     */
    @GetMapping("/delCheckIn/{id}")
    public String delCheckIn(@PathVariable("id") Integer id ){
        checkInService.delCheckInById(id);
        return "redirect:/findByCheckInPage";
    }

    /**
     * 根据负责人姓名查询
     * @param request
     * @param model
     * @return
     */
    @GetMapping("/searchCheckInByName")
    public String searchCheckInByName(HttpServletRequest request, Model model){
        //获取搜索框的值
        String searchword = request.getParameter("search_name");
        //根据号码查询的信息
        List<CheckIn> search_checkin = checkInService.searchCheckInByName(searchword);
        //将信息返回给页面
        model.addAttribute("checkins",search_checkin);
        return "root/check_in";
    }

    /**
     * 添加操作
     * @param checkin
     * @param model
     * @return
     */
    @PostMapping("/addcheckIn")
    public String addcheckIn(CheckIn checkin,Model model){
        System.out.println(checkin.toString());
        //保存信息
        checkInService.insert(checkin);
        //重定向到列表页面
        return "redirect:/findByCheckInPage";
    }

    /**
     * 跳转到更新页面，并数据回显
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/toupdateCheckIn/{id}")
    public String toupdateCheckIn(@PathVariable("id") Integer id,Model model){
        CheckIn checkin = checkInService.findByCheckInId(id);
        System.out.println(checkin.toString());
        model.addAttribute("updateCheckInDate",checkin);
        return "root/updateCheckIn";
    }

    /**
     * 更新
     * @param checkin
     * @param model
     * @return
     */
    @PostMapping("/updatecheckIn")
    public String updatecheckIn(CheckIn checkin,Model model){
        System.out.println(checkin.toString());
        //保存信息
        checkInService.updateByPrimaryKey(checkin);
        //重定向到列表页面
        return "redirect:/findByCheckInPage";
    }

    /**
     * 分页查询数据
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findByCheckInPage")
    public String findByCheckInPage(Model model,
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
            List<CheckIn> userList = checkInService.findAllCheckIn();
            //3.使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
            PageInfo<CheckIn> pageInfo = new PageInfo<CheckIn>(userList,pageSize);
            //4.使用model/map/modelandview等带回前端
            model.addAttribute("checkins",userList);
            model.addAttribute("pageInfo",pageInfo);
        }finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }
        //5.设置返回的jsp/html等前端页面
        // thymeleaf默认就会拼串classpath:/templates/xxxx.html
        return "root/check_in";
    }


}
