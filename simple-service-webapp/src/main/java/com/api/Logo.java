package com.api;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;

/**
 * Created by soft01 on 2017/5/2.
 */
@Path("logo")
public class Logo {
    User user=new User();

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void setDate(@FormParam("name") String name,@FormParam("pws") String pws){
        user.setName(name);
        user.setPsw(pws);
        Util.getFile(user);
    }

}
