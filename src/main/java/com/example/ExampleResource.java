package com.example;

import com.example.manager.PmsManager;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {


  @Inject
  PmsManager pmsManager;

  @Inject
  EventBus eventBus;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello RESTEasy";
  }


  @GET
  @Path("/pms")
  @Produces(MediaType.TEXT_PLAIN)
  public String pms() {
    return pmsManager.test();
  }

  @GET
  @Path("/event-bus")
  @Produces(MediaType.TEXT_PLAIN)
  public String eventBus() {
    //eventBus.send("test01","1712624418@qq.com");
    Message<Object> objectMessage = eventBus.requestAndAwait("test02", "lisi");
    return (String) objectMessage.body();
  }
}
