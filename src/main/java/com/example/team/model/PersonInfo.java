package com.example.team.model;

import java.io.Serializable;


public class PersonInfo implements Serializable {

    private int id;
    private String mem_name;
    private String stu_number;
    private String stu_password;
    private String mem_class;
    private String mem_phone;
    private String team_id;
    private String mem_state;

    public String getStu_password() {
        return stu_password;
    }

    public void setStu_password(String stu_password) {
        this.stu_password = stu_password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public String getStu_number() {
        return stu_number;
    }

    public void setStu_number(String stu_number) {
        this.stu_number = stu_number;
    }

    public String getMem_class() {
        return mem_class;
    }

    public void setMem_class(String mem_class) {
        this.mem_class = mem_class;
    }

    public String getMem_phone() {
        return mem_phone;
    }

    public void setMem_phone(String mem_phone) {
        this.mem_phone = mem_phone;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getMem_state() {
        return mem_state;
    }

    public void setMem_state(String mem_state) {
        this.mem_state = mem_state;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "id=" + id +
                ", mem_name='" + mem_name + '\'' +
                ", stu_number='" + stu_number + '\'' +
                ", stu_password='" + stu_password + '\'' +
                ", mem_class='" + mem_class + '\'' +
                ", mem_phone='" + mem_phone + '\'' +
                ", team_id='" + team_id + '\'' +
                ", mem_state='" + mem_state + '\'' +
                '}';
    }
}
