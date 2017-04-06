package com.example.vanshit.minihope;

/**
 * Created by Vanshit on 04-01-2017.
 */
public class Users {

    private String name,address,problem_des,phone;

    public Users(String name, String address, String problem_des, String phone) {
        this.name = name;
        this.address = address;
        this.problem_des = problem_des;
        this.phone = phone;
    }

    public String getProblem_des() {
        return problem_des;
    }

    public void setProblem_des(String problem_des) {
        this.problem_des = problem_des;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
