package com.wishhust.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericTypeTest {

  // List<String> 非 List<Object>子类
  public static void test1(List<Object> list)  {
    System.out.println("List<Object>");
  }

  //
  public static void test2(Collection<String> list) {
    System.out.println("Collection<String>");
  }

  public static void test3(List<? extends Object> list)  {
    System.out.println("List<?>");
  }

  public static void main(String[] args) {
    List<String> stringList = new ArrayList<>();
//    test1(stringList);    // 编译出错
    test2(stringList);
    test3(stringList);

    List<Object> objectList = new ArrayList<>();
    test1(objectList);
//    test2(objectList);   // 编译出错
  }
}
