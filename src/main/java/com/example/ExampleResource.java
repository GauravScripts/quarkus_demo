package com.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

@Path("/hello")
public class ExampleResource {

    private Map<String, String> names = new HashMap<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("name") String name) {
        String value = names.get(name);
        if (value != null) {
            return "Hello from Quarkus, " + value + "!";
        } else {
            return "No value found for " + name;
        }
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String helloPost(String name) {
        names.put(name, name);
        return "Hello from Quarkus, " + name + "!";
    }

}
