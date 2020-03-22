package com.wishhust.concurrent;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UnsafeDemo {

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    Demo demo = new Demo();
    demo.test();
  }
}

class Demo {

  private int count = 0;

  public void test() throws IllegalAccessException, NoSuchFieldException {
    // 获取unsafe实例
    Class klass = Unsafe.class;
    Field field = klass.getDeclaredField("theUnsafe");
    field.setAccessible(true);
    Unsafe unsafe = (Unsafe) field.get(null);

    // 获取count 的Field
    Class unsafeDemo = Demo.class;
    Field fieldCount = unsafeDemo.getDeclaredField("count");
    field.setAccessible(true);

    // 计算count 的内存偏移量
    long countOffset = unsafe.objectFieldOffset(fieldCount);
    System.out.println(countOffset);

    unsafe.compareAndSwapInt(this, countOffset, count, count + 1);

    System.out.println(unsafe.getInt(this, countOffset));

  }
}


