package com.wishhust.base.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
// new CyclicBarrier(N) , N个线程到达屏障任务之后任务才能执行
  public static void main(String[] args) throws InterruptedException {

    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    // 若将3改为4，程序会一直等待，没有4个线程到达屏障
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    // 若将3改为4，程序会一直等待，没有4个线程到达屏障, 优先执行当任务也不会执行
    CyclicBarrier cyclicBarrier2 = new CyclicBarrier(3, () -> System.out.println("优先执行"));

    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        System.out.println("到达屏障前");
      }
      try {
        cyclicBarrier.await();   // 1个
        cyclicBarrier2.await();
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("执行1");
    });

    Thread thread2 = new Thread(() -> {
      try {
        cyclicBarrier.await(); // 2个
        cyclicBarrier2.await();
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("执行2");
    });

    thread1.start();
    thread2.start();

    try {
      cyclicBarrier.await(); // 3个
      cyclicBarrier2.await();
    } catch (Exception e) {
      e.printStackTrace();
    }
    Thread.sleep(1000);

    System.out.println("主线程");
  }
  // t1   t2   main

}
