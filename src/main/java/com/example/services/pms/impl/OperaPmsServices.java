package com.example.services.pms.impl;

import com.example.services.pms.PmsServices;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OperaPmsServices implements PmsServices {
  @Override
  public String test() {
    return "OperaPmsServices";
  }
}
