package com.wishhust.base.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
  public static void main(String[] args) throws InterruptedException {

    CountDownLatch countDownLatch = new CountDownLatch(2);
    Thread thread1 = new Thread(() -> {
      System.out.println("执行1");
      countDownLatch.countDown();
    });

    Thread thread2 = new Thread(() -> {
      System.out.println("执行2");
      countDownLatch.countDown();
    });
    thread1.start();
    thread2.start();

    // 等待countDownLatch中传入数字为0
    countDownLatch.await(1000, TimeUnit.MILLISECONDS);

    System.out.println("主线程");
  }
}
