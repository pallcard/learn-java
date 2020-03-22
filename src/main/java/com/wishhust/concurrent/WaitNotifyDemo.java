package com.wishhust.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyDemo {
  public synchronized void before() {
    System.out.println("before1");
    notifyAll();
    System.out.println("before2");
  }

  public synchronized void after() {
    System.out.println("after1");
    try {
      wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("after2");
  }

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    WaitNotifyDemo example = new WaitNotifyDemo();
    // 需要线程 先执行 before  再执行  after
    executorService.execute(() -> example.after());
    executorService.execute(() -> example.before());
  }
}
