package com.wishhust.base;

public class ExceptionTest {

  public void testExt() {
    try {
      int i = 10/0;
      System.out.println("testExt - start");
    } catch (Exception e) {
      System.out.println("testExt - e");
//      throw e;
    } finally {
      System.out.println("testExt - finally");
    }
    System.out.println("testExt - end");
  }

  public static void main(String[] args) {
//    try {
      new ExceptionTest().testExt();
      System.out.println("main - start");
//    } catch (Exception e) {
//      System.out.println("main - e");
//    }
    System.out.println("main - end");
  }
}
