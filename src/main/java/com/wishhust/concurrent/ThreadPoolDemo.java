package com.wishhust.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    Executors.newScheduledThreadPool(1);
    Executors.newCachedThreadPool();
    Executors.newSingleThreadExecutor();
  }
}
