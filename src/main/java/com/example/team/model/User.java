package com.example.team.model;

public class User {
    private Integer id;
    private String capital_number;
    private Integer user_phone;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapital_number() {
        return capital_number;
    }

    public void setCapital_number(String capital_number) {
        this.capital_number = capital_number;
    }

    public Integer getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(Integer user_phone) {
        this.user_phone = user_phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", capital_number='" + capital_number + '\'' +
                ", user_phone=" + user_phone +
                ", password='" + password + '\'' +
                '}';
    }
}
