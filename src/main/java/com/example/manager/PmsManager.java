package com.example.manager;

import com.example.services.pms.PmsServices;
import com.example.services.pms.impl.CambriaPmsServices;
import com.example.services.user.UserServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
public class PmsManager {

  @Default
  @Inject
  Instance<PmsServices> pmsServices;

  UserServices userServices;

  PmsManager(UserServices userServices) {
    this.userServices = userServices;
  }

  public String test() {

    String userName = userServices.findUserName();
    System.out.println(userServices.toString());

    String re = "";
//    for (PmsServices pmsService : pmsServices) {
//      if (pmsService instanceof CambriaPmsServices cambriaPmsServices) {
//        re = cambriaPmsServices.test();
//        break;
//      }
//    }

    Instance<CambriaPmsServices> select = pmsServices.select(CambriaPmsServices.class);
    return select.get().test() + "---" + userName;
  }
}
