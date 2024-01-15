package com.example.services.eventButs;

import io.quarkus.vertx.ConsumeEvent;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.concurrent.TimeUnit;

/**
 * Quarkus 允许不同的 bean 使用异步事件进行交互，从而促进松耦合。消息将发送到虚拟地址。它提供 3 种类型的交付机制：
 * <p>
 * 1.点对点 - 发送消息，一个使用者接收消息。如果多个使用者侦听该地址，则应用循环;
 * 2.publish/subscribe - 发布一条消息，所有监听该地址的消费者都在接收该消息;
 * 3.请求/回复 - 发送消息并期待响应。接收方可以异步方式响应消息
 * <p>
 * 使用@ConsumeEvent("emailService")声明消费者.
 * <p>
 * 参考：[USING THE EVENT BUS](https://quarkus.io/guides/reactive-event-bus)
 *
 * @author aidan.liu
 */
@ApplicationScoped
public class EventBusService {


  // 如果未设置，则地址是 Bean 的完全限定名称，例如，在此代码段中，它是com.example.services.eventButs.
  // method 参数是消息正文。如果该方法返回某些内容，则为消息响应。
  // 非阻塞
  @ConsumeEvent("test01")
  public void test01(String msg) {

    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(msg);
  }


  // 阻塞
  @ConsumeEvent(value = "test02", blocking = true)
  public String test02(String msg) {
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    return msg.toUpperCase();
  }
}
