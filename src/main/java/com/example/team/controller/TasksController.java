package com.example.team.controller;

import com.example.team.model.PersonInfo;
import com.example.team.model.Tasks;
import com.example.team.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TasksController {

    @Autowired
    TasksService tasksService;

    //显示未完成的任务
    @RequestMapping("/assignTasks")
    public String findTasks(Model model){

        List<Tasks> task_inhang = tasksService.findTasks();
        model.addAttribute("tasks_inhang",task_inhang);
        return "assignTasks";
    }


    //显示已完成的任务
    @RequestMapping("/completedTasks")
    public String findCompleted(Model model){

        List<Tasks> task_completed = tasksService.findCompleted();
        model.addAttribute("tasks_completed",task_completed);
        return "completedTasks";
    }

    //分配任务
    @PostMapping("/taskAssign")
    public String taskAssign(Tasks task){
        //刚分配的任务，设状态为未完成
        task.setAssign_state("0");
        tasksService.save(task);
        return "redirect:/assignTasks";
    }

    //根据任务名称查找已完成任务
    @RequestMapping("/findCompletedTasks")
    public String findTask(HttpServletRequest servletRequest,Model model){
        String task_name = servletRequest.getParameter("search");
        List<Tasks> task_completed = tasksService.findByTaskName(task_name);
        model.addAttribute("tasks_completed",task_completed);
        return "completedTasks";
    }


    @RequestMapping("/findAllAssign")
    public String findAllAssign(HttpServletRequest request, Model model){
        //通过session查找学号来进行查找任务
        HttpSession session = request.getSession();
        PersonInfo personInfo = (PersonInfo) session.getAttribute("personInfo");
        List<Tasks> tasks = tasksService.findAllAssign(personInfo.getStu_number());
        model.addAttribute("tasks", tasks);
        return "student/teamAssignment";
    }

    @RequestMapping("/findAllAssignAjax")
    @ResponseBody
    public List<Tasks> findAllAssignAjax(HttpServletRequest request){
        //通过session查找学号来进行查找任务
        HttpSession session = request.getSession();
        PersonInfo personInfo = (PersonInfo) session.getAttribute("personInfo");
        return tasksService.findAllAssign(personInfo.getStu_number());
    }

    @RequestMapping("/searchTasks")
    @ResponseBody
    public List<Tasks> searchTasks(String inputs, HttpServletRequest request){
        //通过session查找学号来进行查找任务
        HttpSession session = request.getSession();
        PersonInfo personInfo = (PersonInfo) session.getAttribute("personInfo");
        return tasksService.searchTasks(inputs, personInfo.getStu_number());
    }

    @RequestMapping("/updateAssignState")
    @ResponseBody
    public String updateAssignState(Integer id, String assign_state){
        return tasksService.updateAssignState(id, assign_state);
    }

}
