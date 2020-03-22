package com.wishhust.concurrent;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UnsafeDemo2 {

  public static void main(String[] args) throws InterruptedException {
    final Demo2 demo2 = new Demo2();
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000000; i++) {
          demo2.addCount();
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000000; i++) {
          demo2.addCount();
        }
      }
    }).start();

    Thread.sleep(1000);
    System.out.println(demo2.getCount());
  }

}


class Demo2 {

  private int count = 0;
// 不能通过Unsafe.getUnsafe(),
// 当调用改方法后，会使用VM.isSystemDomainLoader方法校验调用者的ClassLoader,
// 如果调用者的ClassLoader==null（启动类加载器（BootstrapClassLoader）），
// 在getUnsafe方法中才可以成功返回实例，否则会抛出SecurityException("Unsafe")异常。
//  private Unsafe unsafe = Unsafe.getUnsafe();
  private Unsafe unsafe;

  private Object lock = new Object();

  public void addCount() {
    // 给lock对象设置锁
    unsafe.monitorEnter(lock);
    count++;
    // 给lock对象解锁
    unsafe.monitorExit(lock);
  }

  public Demo2() {
    try {
      // 获取unsafe实例
      Class klass = Unsafe.class;
      Field field = klass.getDeclaredField("theUnsafe");
      field.setAccessible(true);
      unsafe = (Unsafe) field.get(null);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public int getCount() {
    return this.count;
  }

}


