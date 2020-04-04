package com.wishhust.base.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
  // 可以控制两个线程交换彼此数据。如果两个线程有一个exchange()方法没有执行，则会一直等待。exchange()方法里也可以设置最大等待时间。
  private static final Exchanger<String> exgr = new Exchanger<>();

  private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

  public static void main(String[] args) {

    threadPool.execute(()->{
      String A = "流水A";
      try {
        String B = exgr.exchange(A + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName()+A.equals(B)+ " A: " + A + " B: " + B);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    threadPool.execute(()->{
      String B = "流水B";
      try {
        String A = exgr.exchange(B+ Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName()+A.equals(B)+ " A: " + A + " B: " + B);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    threadPool.shutdown();
  }
}
