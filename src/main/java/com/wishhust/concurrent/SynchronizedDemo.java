package com.wishhust.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SynchronizedDemo implements Runnable {
  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    if (threadName.startsWith("A")) {
      async();
    } else if (threadName.startsWith("B")) {
      sync1();
    } else if (threadName.startsWith("C")) {
      sync2();
    }

  }

  /**
   * 异步方法
   */
  private void async() {
    try {
      System.out.println(Thread.currentThread().getName() + "_Async_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
      Thread.sleep(2000);
      System.out.println(Thread.currentThread().getName() + "_Async_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * 方法中有 synchronized(this|object) {} 同步代码块
   */
  private void sync1() {
    System.out.println(Thread.currentThread().getName() + "_Sync1: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    synchronized (this) {
      try {
        System.out.println(Thread.currentThread().getName() + "_Sync1_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date())+"a1");
        if (Thread.currentThread().getName().contains("thread1")) {
          Thread.sleep(2000);
        } else {
          Thread.sleep(4000);
        }
        System.out.println(Thread.currentThread().getName() + "_Sync1_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date())+"a2");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * synchronized 修饰非静态方法
   */
  private synchronized void sync2() {
    System.out.println(Thread.currentThread().getName() + "_Sync2: " + new SimpleDateFormat("HH:mm:ss").format(new Date())+"b1");
    try {
      System.out.println(Thread.currentThread().getName() + "_Sync2_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date())+"b2");
      Thread.sleep(2000);
      System.out.println(Thread.currentThread().getName() + "_Sync2_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date())+"b3");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String... args) {

    // 获取同一个锁
//    SynchronizedDemo syncThread = new SynchronizedDemo();
//    Thread A_thread1 = new Thread(syncThread, "A_thread1");
//    Thread A_thread2 = new Thread(syncThread, "A_thread2");
//    Thread B_thread1 = new Thread(syncThread, "B_thread1");
//    Thread B_thread2 = new Thread(syncThread, "B_thread2");
//    Thread C_thread1 = new Thread(syncThread, "C_thread1");
//    Thread C_thread2 = new Thread(syncThread, "C_thread2");
//    A_thread1.start();
//    A_thread2.start();
//    B_thread1.start();
//    B_thread2.start();
//    C_thread1.start();
//    C_thread2.start();

    // 获取不同的锁
    Thread A_thread1_2 = new Thread(new SynchronizedDemo(), "A_thread1");
    Thread A_thread2_2 = new Thread(new SynchronizedDemo(), "A_thread2");
    Thread B_thread1_2 = new Thread(new SynchronizedDemo(), "B_thread1");
    Thread B_thread2_2 = new Thread(new SynchronizedDemo(), "B_thread2");
    Thread C_thread1_2 = new Thread(new SynchronizedDemo(), "C_thread1");
    Thread C_thread2_2 = new Thread(new SynchronizedDemo(), "C_thread2");
    A_thread1_2.start();
    A_thread2_2.start();
    B_thread1_2.start();
    B_thread2_2.start();
    C_thread1_2.start();
    C_thread2_2.start();


  }
}
