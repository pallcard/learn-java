package com.wishhust.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class JMMDemo {
  private AtomicInteger cnt = new AtomicInteger();

  private volatile int cntVolatile = 0;

  public void add() {
    cnt.incrementAndGet();
    cntVolatile++;
  }

  public int getCntVolatile(){
    return cntVolatile;
  }

  public int get() {
    return cnt.get();
  }

  public static void main(String[] args) throws InterruptedException {
    final int threadSize = 1000;
    JMMDemo example = new JMMDemo(); // 只修改这条语句
    // 用来控制一个或者多个线程等待多个线程。
    //维护了一个计数器 cnt，每次调用 countDown() 方法会让计数器的值减 1，减到 0 的时候，
    //那些因为调用 await() 方法而在等待的线程就会被唤醒。
    final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i < threadSize; i++) {
      executorService.execute(() -> {
        example.add();
        countDownLatch.countDown();
      });
    }
    // 控制上面10个线程执行完毕，在接着执行main线程
    countDownLatch.await();
    executorService.shutdown();
    System.out.println(example.get());
    System.out.println(example.getCntVolatile());
  }

}
