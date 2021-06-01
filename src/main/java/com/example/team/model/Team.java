package com.example.team.model;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "zxl_team")
public class Team implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String stu_number;
    private String stu_pwd;
    private String stu_phone;
    private String team_type;
    private String team_name;
    private String team_Exp_title;
    private String is_enjor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_number() {
        return stu_number;
    }

    public void setStu_number(String stu_number) {
        this.stu_number = stu_number;
    }

    public String getStu_pwd() {
        return stu_pwd;
    }

    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

    public String getStu_phone() {
        return stu_phone;
    }

    public void setStu_phone(String stu_phone) {
        this.stu_phone = stu_phone;
    }

    public String getTeam_type() {
        return team_type;
    }

    public void setTeam_type(String team_type) {
        this.team_type = team_type;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_Exp_title() {
        return team_Exp_title;
    }

    public void setTeam_Exp_title(String team_Exp_title) {
        this.team_Exp_title = team_Exp_title;
    }

    public String getIs_enjor() {
        return is_enjor;
    }

    public void setIs_enjor(String is_enjor) {
        this.is_enjor = is_enjor;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", stu_number='" + stu_number + '\'' +
                ", stu_pwd='" + stu_pwd + '\'' +
                ", stu_phone='" + stu_phone + '\'' +
                ", team_type='" + team_type + '\'' +
                ", team_name='" + team_name + '\'' +
                ", team_Exp_title='" + team_Exp_title + '\'' +
                ", is_enjor='" + is_enjor + '\'' +
                '}';
    }
}
