package com.wishhust.base;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

  public static void main(String[] args) {
//    可以看到，在主线程调用park阻塞后，在myThread线程中发出了中断信号，
//   此时主线程会继续运行，也就是说明此时interrupt起到的作用与unpark一样。
//    MyThread myThread = new MyThread(Thread.currentThread());
    MyThread2 myThread = new MyThread2(Thread.currentThread());
    myThread.start();
    System.out.println("before park");
    // 获取许可
    LockSupport.park("ParkAndUnparkDemo");
    System.out.println("after park");
  }
}


class MyThread extends Thread {
  private Object object;

  public MyThread(Object object) {
    this.object = object;
  }

  public void run() {
    System.out.println("before interrupt");
    try {
      // 休眠3s
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Thread thread = (Thread) object;
    // 中断线程
    thread.interrupt();
    System.out.println("after interrupt");
  }
}


class MyThread2 extends Thread {
  private Object object;

  public MyThread2(Object object) {
    this.object = object;
  }

  public void run() {
    System.out.println("before unpark");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 获取blocker
    System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
    // 释放许可
    LockSupport.unpark((Thread) object);
    // 休眠500ms，保证先执行park中的setBlocker(t, null);
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 再次获取blocker
    System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));

    System.out.println("after unpark");
  }
}