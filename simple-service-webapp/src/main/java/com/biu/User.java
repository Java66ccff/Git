package com.biu;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by soft01 on 2017/5/5.
 */
public class User {
    private String username;
    private String name;
    private int age;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;


    public User(String username, String name, int age, Date birthday) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public User() {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
