package com.wishhust.base;

public class ThreadLocalTest {
  private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
    @Override
    protected Integer initialValue() {
      return Integer.valueOf(1);
    }
  };

  public static void main(String[] args) {
    Thread[] threads = new Thread[2];
    for (int i=0;i<2;i++) {
      threads[i] = new Thread(() -> {
        System.out.println(Thread.currentThread() +"'s initial value: " + threadLocal.get());
        for (int j=0;j<10;j++) {
          threadLocal.set(threadLocal.get() + j);
        }
        System.out.println(Thread.currentThread() +"'s last value: " + threadLocal.get());
      });
    }

    for (Thread t: threads)
      t.start();
  }
}
