package com.wishhust.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

  public static int count = 0;

  public static void main(String[] args) throws InterruptedException {
//    ReentrantLock lock = new ReentrantLock(true);
    ReentrantLock lock = new ReentrantLock();
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 5; i++) {
      executorService.execute(()->{
        lock.lock();
//        try {
//          lock.lockInterruptibly();
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName()+ " start");
        for (int j = 0; j < 10; j++) {
          System.out.println(Thread.currentThread().getName()+ " " +count++);
        }
        System.out.println(Thread.currentThread().getName()+ " end");
        lock.unlock();
      });
    }

    Thread.sleep(5000);
    System.out.println(count);

  }
}
