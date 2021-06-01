package com.example.team.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

//@Entity
//@Table(name = "zxl_assignTasks")
public class Tasks implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String task_name;
    private String difficulty;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/ShangHai")
    private Date closing_time;
    private String task_text;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/ShangHai")
    private Date release_time;
    private String assign_state;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/ShangHai")
    private Date end_time;
    private String task_people_number;

    private PersonInfo personInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Date getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(Date closing_time) {
        this.closing_time = closing_time;
    }

    public String getTask_text() {
        return task_text;
    }

    public void setTask_text(String task_text) {
        this.task_text = task_text;
    }

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public String getAssign_state() {
        return assign_state;
    }

    public void setAssign_state(String assign_state) {
        this.assign_state = assign_state;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getTask_people_number() {
        return task_people_number;
    }

    public void setTask_people_number(String task_people_number) {
        this.task_people_number = task_people_number;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", task_name='" + task_name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", closing_time=" + closing_time +
                ", task_text='" + task_text + '\'' +
                ", release_time=" + release_time +
                ", assign_state='" + assign_state + '\'' +
                ", end_time=" + end_time +
                ", task_people_number='" + task_people_number + '\'' +
                ", personInfo=" + personInfo +
                '}';
    }
}
