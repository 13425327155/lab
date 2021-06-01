package com.example.team.model;


import java.io.Serializable;

public class Root implements Serializable {
    private Integer id;
    private String root_name;
    private String root_password;
    private String root_phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoot_name() {
        return root_name;
    }

    public void setRoot_name(String root_name) {
        this.root_name = root_name;
    }

    public String getRoot_password() {
        return root_password;
    }

    public void setRoot_password(String root_password) {
        this.root_password = root_password;
    }

    public String getRoot_phone() {
        return root_phone;
    }

    public void setRoot_phone(String root_phone) {
        this.root_phone = root_phone;
    }

    @Override
    public String toString() {
        return "Root{" +
                "id=" + id +
                ", root_name='" + root_name + '\'' +
                ", root_password='" + root_password + '\'' +
                ", root_phone='" + root_phone + '\'' +
                '}';
    }
}
