package com.wishhust.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SynchronizedDemo3 implements Runnable {

  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    if (threadName.startsWith("B")) {
      sync1();
    } else if (threadName.startsWith("C")) {
      sync2();
    }

  }

  /**
   * synchronized 修饰非静态方法
   */
  private synchronized void sync1() {
    try {
      System.out.println(Thread.currentThread().getName() + "_Sync1_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
      Thread.sleep(2000);
      System.out.println(Thread.currentThread().getName() + "_Sync1_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * synchronized 修饰静态方法
   */
  private synchronized static void sync2() {
    try {
      System.out.println(Thread.currentThread().getName() + "_Sync2_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
      Thread.sleep(2000);
      System.out.println(Thread.currentThread().getName() + "_Sync2_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String... args) {
    SynchronizedDemo3 syncThread = new SynchronizedDemo3();
    Thread B_thread1 = new Thread(syncThread, "B_thread1");
    Thread C_thread1 = new Thread(syncThread, "C_thread1");
    B_thread1.start();
    C_thread1.start();

  }
}
