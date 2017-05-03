package com.api;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by soft01 on 2017/5/2.
 */
@Path("select")
public class select_Logo {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getDate(@QueryParam("name") String name) {
//        System.out.println(name);
        List<User> list = Util.isName(name);
//        System.out.println(json);
        Date date = new Date();
        date.setStatus(Util.getStatus());
        date.setResult(list);
        String str = JSON.toJSONString(date);
        return str;
    }
}
