package com.example.team.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class Apply {
    private int id;
    private String apply_people;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/ShangHai")
    private Date apply_time;
    private String apply_phone;
    private String team_type;
    private String team_name;
    private String is_responsibility;
    private String distribution_lab;
    private String apply_state;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/ShangHai")
    private Date start_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/ShangHai")
    private Date end_time;
    private String apply_purpose;
    private String team_member;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApply_people() {
        return apply_people;
    }

    public void setApply_people(String apply_people) {
        this.apply_people = apply_people;
    }

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }

    public String getApply_phone() {
        return apply_phone;
    }

    public void setApply_phone(String apply_phone) {
        this.apply_phone = apply_phone;
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

    public String getIs_responsibility() {
        return is_responsibility;
    }

    public void setIs_responsibility(String is_responsibility) {
        this.is_responsibility = is_responsibility;
    }

    public String getDistribution_lab() {
        return distribution_lab;
    }

    public void setDistribution_lab(String distribution_lab) {
        this.distribution_lab = distribution_lab;
    }

    public String getApply_state() {
        return apply_state;
    }

    public void setApply_state(String apply_state) {
        this.apply_state = apply_state;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getApply_purpose() {
        return apply_purpose;
    }

    public void setApply_purpose(String apply_purpose) {
        this.apply_purpose = apply_purpose;
    }

    public String getTeam_member() {
        return team_member;
    }

    public void setTeam_member(String team_member) {
        this.team_member = team_member;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", apply_people='" + apply_people + '\'' +
                ", apply_time=" + apply_time +
                ", apply_phone='" + apply_phone + '\'' +
                ", team_type='" + team_type + '\'' +
                ", team_name='" + team_name + '\'' +
                ", is_responsibility='" + is_responsibility + '\'' +
                ", distribution_lab='" + distribution_lab + '\'' +
                ", apply_state='" + apply_state + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time=" + end_time +
                ", apply_purpose=" + apply_purpose +
                ", team_member='" + team_member + '\'' +
                '}';
    }
}
