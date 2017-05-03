package com.api;

import java.util.List;

/**
 * Created by soft01 on 2017/5/2.
 */
public class Date {
    private List<User> result;
    private int status;
    public int getStatus() {
        return status;
    }

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
