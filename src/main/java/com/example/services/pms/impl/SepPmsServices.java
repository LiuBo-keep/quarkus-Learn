package com.example.services.pms.impl;

import com.example.services.pms.PmsServices;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SepPmsServices implements PmsServices {
  @Override
  public String test() {
    return "SepPmsServices";
  }
}
