package com.wishhust.base.concurrent;


public class TwoThreadPrint {

  public static int count = 1;
  private static final Object lock = new Object();

  public static void main(String[] args) {

    Thread thread = new Thread(() -> {
      while (count <= 100) {
        synchronized (lock) {
          System.out.println("threadA:" + count++);
          lock.notifyAll();
          try {
            if (count <= 100) {
              lock.wait();
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });


    Thread thread2 = new Thread(() -> {
      while (count <= 100) {
        synchronized (lock) {
          System.out.println("threadB:" + count++);
          lock.notifyAll();
          try {
            if (count <= 100) {
              lock.wait();
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });


    thread.start();
    try {
      Thread.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread2.start();
  }
}
