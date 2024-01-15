package com.example.services.user;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Singleton;

@ApplicationScoped
public class UserServices {

  public UserServices() {
    System.out.println("UserServices....");
  }

  @PostConstruct
  void init() {
    System.out.println("init....");
  }

  public String findUserName() {
    return "lisi";
  }

  @PreDestroy
  void destroy() {
    System.out.println("destroy...");
  }
}
