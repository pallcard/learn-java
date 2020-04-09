package com.wishhust.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

  static final Lock lock = new ReentrantLock();
  static final Condition condition = lock.newCondition();

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(()->{
      lock.lock();
      System.out.println(Thread.currentThread().getName()+" 正在运行... ");
      try {
        Thread.sleep(2 * 1000);
        System.out.println(Thread.currentThread().getName() + " 停止运行, 等待一个 signal");
        condition.await();  // 调用 condition.await 进行释放锁, 将当前节点封装成一个 Node 放入 Condition Queue 里面, 等待唤醒
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + " 获取一个 signal");
      lock.unlock();
    });
    thread.start();
    Thread.sleep(1 * 1000);

    Thread thread2 = new Thread(()->{
      lock.lock();
      System.out.println(Thread.currentThread().getName()+" 正在运行... ");
      thread.interrupt();
      try {
        Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
        e.printStackTrace();
      }
      condition.signal();
      System.out.println(Thread.currentThread().getName() + " 发送一个 signal");
      lock.unlock();
    });
    thread2.start();
  }

}
