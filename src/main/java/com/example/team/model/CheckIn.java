package com.example.team.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


public class CheckIn implements Serializable {

    private int id;
    private String name;
    private String team_type;
    private String team_phone;
    private String team_name;
    private String lab_name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/ShangHai")
    private Date in_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/ShangHai")
    private Date out_time;
    private String team_member;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam_type() {
        return team_type;
    }

    public void setTeam_type(String team_type) {
        this.team_type = team_type;
    }

    public String getTeam_phone() {
        return team_phone;
    }

    public void setTeam_phone(String team_phone) {
        this.team_phone = team_phone;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getLab_name() {
        return lab_name;
    }

    public void setLab_name(String lab_name) {
        this.lab_name = lab_name;
    }

    public Date getIn_time() {
        return in_time;
    }

    public void setIn_time(Date in_time) {
        this.in_time = in_time;
    }

    public Date getOut_time() {
        return out_time;
    }

    public void setOut_time(Date out_time) {
        this.out_time = out_time;
    }

    public String getTeam_member() {
        return team_member;
    }

    public void setTeam_member(String team_member) {
        this.team_member = team_member;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team_type='" + team_type + '\'' +
                ", team_phone='" + team_phone + '\'' +
                ", team_name='" + team_name + '\'' +
                ", lab_name='" + lab_name + '\'' +
                ", in_time=" + in_time +
                ", out_time=" + out_time +
                ", team_member='" + team_member + '\'' +
                '}';
    }
}
