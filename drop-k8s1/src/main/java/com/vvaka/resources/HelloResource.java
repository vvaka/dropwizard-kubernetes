package com.vvaka.resources;

import org.glassfish.jersey.client.ClientResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

/**
 * Created by vvaka on 8/16/15.
 */
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {

    private String otherAppUrl;
    private Client client;

    public HelloResource(String otherAppUrl) {
        this.client = ClientBuilder.newClient();
        this.otherAppUrl = otherAppUrl;
    }

    @Path("/other")
    @GET
    public Response hello() throws ExecutionException, UnknownHostException {

        final InetAddress ip = InetAddress.getLocalHost();
        final String hostname = ip.getHostName();
        Map<String, String> map = new HashMap<String, String>() {
            {
                put("msg", "Hello..... from drop-k8s1");
                put("ip", ip.getHostAddress());
                put("hostname", ip.getHostName());
            }
        };

        return Response.ok(map).build();
    }

    @Path("/")
    @GET
    public Response hello2() throws ExecutionException, InterruptedException {

        Map<String,Object> map = new LinkedHashMap<>();
        map.put("msg","Hello from Drop-K8s1111111111111111111");
        map.put("serviceUrl",otherAppUrl);
        map.put("##","########################################################");
        //Loop over 10times
        IntStream.range(0, 10).forEachOrdered(n -> {
            Client client1 = ClientBuilder.newClient();
            Map map2 = client1.target(otherAppUrl).path("/hello/other").request().get(Map.class);
            map.put("otherMsg"+n, map2);  //work on n here
        });
        return Response.ok(map).build();
    }
}
