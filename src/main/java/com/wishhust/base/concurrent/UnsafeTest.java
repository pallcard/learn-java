package com.wishhust.base.concurrent;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UnsafeTest {

  // 获取Unsafe，
  // 方法一：通过Java命令行命令-Xbootclasspath/a把调用Unsafe相关方法的类A所在jar包路径追加到默认的bootstrap路径中，使得A被引导类加载器加载，从而通过Unsafe.getUnsafe方法安全的获取Unsafe实例。
  // java -Xbootclasspath/a: ${path}   // 其中path为调用Unsafe相关方法的类所在jar包路径

  // 方法二：反射
  public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
    Field field = Unsafe.class.getDeclaredField("theUnsafe");
    field.setAccessible(true);
    Unsafe unsafe = (Unsafe) field.get(null);
  }
}
