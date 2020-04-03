package com.wishhust.base.concurrent;

import java.util.concurrent.Semaphore;

public class MoreThreadPrint {

  static int count = 0;

  // T1、T2、T3三个线程顺序执行
  public static void main(String[] args) {
    Semaphore c0 = new Semaphore(1);
    Semaphore c1 = new Semaphore(0);
    Semaphore c2 = new Semaphore(0);

    Worker worker = new Worker(c0, c1);
    Worker worker1 = new Worker(c1, c2);
    Worker worker2 = new Worker(c2, c0);

    Thread t1 = new Thread(worker);
    Thread t2 = new Thread(worker1);
    Thread t3 = new Thread(worker2);

    t1.start();
    t2.start();
    t3.start();
  }


  static class Worker implements Runnable {

    Semaphore c0;
    Semaphore c1;

    public Worker(Semaphore c0, Semaphore c1) {
      this.c0 = c0;
      this.c1 = c1;
    }

    @Override
    public void run() {
      while (count < 100) {
        try {
          c0.acquire();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+count++);
        c1.release();
      }
    }
  }
}