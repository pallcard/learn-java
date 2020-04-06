package com.wishhust.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest3 {

  public static Lock lock = new ReentrantLock();

  public static int count = 0;

  public static void main(String[] args) {

    Thread t1 = new Thread(() -> {

      lock.lock();

      System.out.println(Thread.currentThread().getName()+"start");
      for (int i = 0; i < 100000; i++) {
        System.out.println(Thread.currentThread().getName()+" :"+count++);
      }
      System.out.println(Thread.currentThread().getName()+".....");
      System.out.println(Thread.currentThread().getName()+"end");

      lock.unlock();

    });

    Thread t2 = new Thread(() -> {
      try {
        lock.lockInterruptibly();
//        lock.lock();
      } catch (Exception e) {
        System.out.println(Thread.currentThread().getName()+"interrupt");
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName()+"start");

      for (int i = 0; i < 100000; i++) {
        System.out.println(Thread.currentThread().getName()+" :"+count++);
      }

      System.out.println(Thread.currentThread().getName()+"end");

      lock.unlock();
    });

    t1.start();
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t2.start();

    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t2.interrupt();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() +" :"+count);
  }
}
