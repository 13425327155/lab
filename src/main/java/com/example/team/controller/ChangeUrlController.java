package com.example.team.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChangeUrlController {

    @RequestMapping("/rootLogin")
    public ModelAndView rootIndex() {
        return new ModelAndView("root/rootLogin");
    }
    @RequestMapping("/stuLogin")
    public ModelAndView stuIndex() {
        return new ModelAndView("student/stuLogin");
    }

    @RequestMapping("/teamLogin")
    public ModelAndView teamIndex() {
        return new ModelAndView("index");
    }

    //返回页面
    @RequestMapping("/team_index")
    public ModelAndView team_index() {
        return new ModelAndView("team_index");
    }


//    @RequestMapping("/managingMembers")
//    public ModelAndView managingMembers() {
//        return new ModelAndView("managingMembers");
//    }

//    @RequestMapping("/recruit")
//    public ModelAndView recruit() {
//        return new ModelAndView("recruit");
//    }

//    @RequestMapping("/assignTasks")
//    public ModelAndView assignTasks() {
//        return new ModelAndView("assignTasks");
//    }

//    @RequestMapping("/completedTasks")
//    public ModelAndView completedTasks() {
//        return new ModelAndView("completedTasks");
//    }

    @RequestMapping("/responsibility")
    public ModelAndView responsibility() {
        return new ModelAndView("responsibility");
    }

    @RequestMapping("/apply")
    public ModelAndView apply() {
        return new ModelAndView("apply");
    }
//    @RequestMapping("/queryApply")
//    public ModelAndView queryApply() {
//        return new ModelAndView("queryApply");
//    }

    @RequestMapping("/teacher_index")
    public ModelAndView index_teacher() {
        return new ModelAndView("teacher_index");
    }

    @RequestMapping("/achievement")
    public ModelAndView achievement() {
        return new ModelAndView("achievement");
    }

//    @RequestMapping("/queryAchievement")
//    public ModelAndView queryAchievements() {
//        return new ModelAndView("queryAchievements");
//    }

    @RequestMapping("/checkIn")
    public ModelAndView checkIn() {
        return new ModelAndView("checkIn");
    }

//    @RequestMapping("/team")
//    public ModelAndView team() {
//        return new ModelAndView("team");
//    }

    @RequestMapping("/team_update")
    public ModelAndView team_update(){
        return new ModelAndView("team_update");
    }
}
