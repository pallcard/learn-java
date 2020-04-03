package com.wishhust.base.concurrent;

public class JoinTest {
  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(() -> {
      System.out.println("执行1");
    });
    Thread thread2 = new Thread(() -> {
      System.out.println("执行2");
    });

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
    System.out.println("主线程");
  }
}
