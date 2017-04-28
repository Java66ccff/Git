package main.java.com.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.alibaba.fastjson.JSON;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("user")
public class MyResource {
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces("application/json")
    public String getIt() {
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        String jsonString = JSON.toJSONString(group);
        return jsonString;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String postIt() {
        return "用户：张三post";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String putIt() {
        return "用户：张三post";
    }
}