package com.example.team.controller;

import com.example.team.model.PersonInfo;
import com.example.team.model.Team;
import com.example.team.service.PersonInfoService;
import com.example.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class TeamController {
    @Autowired
    TeamService teamService;

    //登录
    @PostMapping("/teamLogin")
    public String teamLogin(@RequestParam("stu_number") String stu_number, @RequestParam("stu_pwd") String stu_pwd, Map<String, Object> map, HttpServletRequest servletRequest){
        Team teamcheck = teamService.teamLogin(stu_number,stu_pwd);
        HttpSession session = servletRequest.getSession();
        if (teamcheck != null){     //登录成功
            //将信息存入session
            servletRequest.getSession().setAttribute("teamInfo", teamcheck);
            Team w = (Team) session.getAttribute("teamInfo");
//            System.out.println(w.getId());
            return "team_index";
        }
        else{
            map.put("loginError", "用户名或密码错误，请重新登录！");
            return "index";
        }
    }

    //退出登录
    @GetMapping("teamLogout")
    public String teamlogout(HttpServletRequest servletRequest){
        HttpSession session = servletRequest.getSession();
        //移除信息
        session.removeAttribute("teamInfo");
        return "index";
    }

    //查看团队信息
    @Autowired
    private PersonInfoService personInfoService;

    //查看团队信息
    @RequestMapping("/team")
    public String findTeamInfo(HttpServletRequest servletRequest, Model model){
        HttpSession session = servletRequest.getSession();
        Team w = (Team) session.getAttribute("teamInfo");
        String stu_number = String.valueOf(w.getStu_number());
        List<Team> team = teamService.findByStuNum(stu_number);
        model.addAttribute("teams",team);

        PersonInfo personInfo = personInfoService.findByStuNum(stu_number);
        model.addAttribute("personInfos",personInfo);

        String team_id = String.valueOf(w.getId());
        List<PersonInfo> personInfos = personInfoService.findByTeamId(team_id);
        model.addAttribute("personinfo",personInfos);

        return "team";
    }

    //修改团队信息
    @PostMapping("/updateTeam")
    public String updateteam(HttpServletRequest servletRequest,Team team){
        HttpSession session = servletRequest.getSession();
        Team w = (Team) session.getAttribute("teamInfo");
        String team_id = String.valueOf(w.getId());

        String team_pwd = String.valueOf(team.getStu_pwd());
        String stu_number = String.valueOf(team.getStu_number());

        PersonInfo personInfo = personInfoService.findByStuNum(stu_number);
        if (personInfo==null){
            return "redirect:/team_update";
        }
        String p_id = String.valueOf(personInfo.getTeam_id());
        String p_pwd = String.valueOf(personInfo.getStu_password());
        String p_num = String.valueOf(personInfo.getStu_number());

        if (team_id.equals(p_id) && team_pwd.equals(p_pwd) && p_num.equals(stu_number)){
            team.setId(w.getId());
            teamService.save(team);
            session.removeAttribute("teamInfo");
            servletRequest.getSession().setAttribute("teamInfo",team);
            return "redirect:/team";
        }
        else {
            return "redirect:/team_update";
        }


    }


    @RequestMapping("/viewTeamList")
    @ResponseBody
    public List<Team> viewTeamList(){
        return teamService.viewTeamList();
    }

    @RequestMapping("/findAllTeam")
    public String findAllTeam(Model model){
        List<Team> teamList = teamService.viewTeamList();
        model.addAttribute("teamList", teamList);
        return "student/viewTeamList";
    }
    @RequestMapping("/updateState")
    public String updateState(int id, String stu_number, String stu_password, Model model){
        //搜寻个人id
        PersonInfo id1 = personInfoService.findPersonInfoId(stu_number, stu_password);
        id1.setMem_state(personInfoService.findPersonInfoById(id1.getId()));
        //修改team_id在个人id
        personInfoService.updateState(String.valueOf(id), id1.getId());
        model.addAttribute("mem_state", id1.getMem_state());
        List<Team> teamList = teamService.viewTeamList();
        model.addAttribute("teamList", teamList);
        return "student/viewTeamList";
    }

    @RequestMapping("/ajax")
    @ResponseBody
    public String ajax(String id, HttpServletRequest request){
        HttpSession session = request.getSession();
        PersonInfo personInfos = (PersonInfo) session.getAttribute("personInfo");
        //搜寻个人id
        PersonInfo id1 = personInfoService.findPersonInfoId(personInfos.getStu_number(), personInfos.getStu_password());
        id1.setMem_state(personInfoService.findPersonInfoById(id1.getId()));
        //修改team_id在个人id
        personInfoService.updateState(String.valueOf(id), id1.getId());
        return id1.getMem_state();
    }

    @PostMapping("/searchTeam")
    @ResponseBody
    public List<Team> searchTeam(String inputs){
        return teamService.searchTeamList(inputs);
    }

    @RequestMapping("/deleteMem_state")
    public String deleteMem_state(String stu_number, Model model){
        personInfoService.deleteMem_state(stu_number);
        PersonInfo personInfo = personInfoService.findPersonInfo(stu_number);
        model.addAttribute("personInfo", personInfo);
        return "student/personInfo";
    }

}
