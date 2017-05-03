package com.api;

import com.alibaba.fastjson.JSON;

/**
 * Created by soft01 on 2017/5/2.
 */
public class User {
    private String name;
    private String psw;

    public String getName() {
        return name;
    }

    public String getPsw() {
        return psw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}

