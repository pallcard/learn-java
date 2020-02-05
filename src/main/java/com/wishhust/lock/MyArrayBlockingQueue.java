package com.wishhust.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** Created by liuke on 2020/1/8 18:09 */
public class MyArrayBlockingQueue<T> {
  // 维护的数据
  private final T[] datas;
  // 数据的个数
  private int count;
  // 插入取出的索引
  private int put_index;
  private int take_index;

  // 锁
  private final Lock lock = new ReentrantLock();
  // 定义两个条件，分别为“集合满”和“集合空”
  private Condition full = lock.newCondition();
  private Condition empty = lock.newCondition();

  // 提供MyArrayBlockingQueue的构造方法，初始化T[]数据
  public MyArrayBlockingQueue() {
    this(10);
  }

  public MyArrayBlockingQueue(int maxSize) {
    this.datas = (T[]) new Object[maxSize];
  }

  public void put(T data) {
    lock.lock();
    try {
      if (count == datas.length) {
        // 此时集合已经满了
        System.out.println("集合已满，请等待...");
        // 使调用线程挂起
        full.await();
      }
      // 不满则添加新元素
      datas[put_index++] = data;
      if (put_index == datas.length) {
        put_index = 0;
      }
      count++;

      // 此时唤醒等待取数据的线程
      empty.signalAll();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public T take() {
    lock.lock();
    try {
      if (count == 0) {
        // 此时集合已经空了
        System.out.println("集合已空，请等待...");
        // 使调用线程挂起
        empty.await();
      }

      T result = datas[take_index++];
      if (take_index == datas.length) {
        take_index = 0;
      }
      count--;

      // 此时唤醒等待写数据的线程
      full.signalAll();

      return result;

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
    return null;
  }

  public static void main(String[] args) throws InterruptedException {

    MyArrayBlockingQueue myArrayBlockingQueue = new MyArrayBlockingQueue();


    ExecutorService executorService = Executors.newFixedThreadPool(20);
    for (int i = 0; i < 20; i++) {
      executorService.execute(
          () -> {
            System.out.println("put: "+ "String");
            myArrayBlockingQueue.put("String");
          });
    }

    Thread.sleep(1000);

    for (int i = 0; i < 20; i++) {
      executorService.execute(
          () -> {
            String take = (String) myArrayBlockingQueue.take();
            System.out.println("take: " + take);
          });
    }


  }
}
