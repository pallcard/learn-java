package com.wishhust.test;


import java.util.Date;

public class TestParent {
  public static void test() {
    System.out.println("parent");
  }
  public  void test1() {
    System.out.println("parent1");
  }
}

class TestSon extends TestParent {
  public static void test(){
    System.out.println("son");
  }
  public void test1(){
    System.out.println("son1");
  }
  public static void main(String[] args) {
    TestSon test = new TestSon();
    test.test();
    test.test1();
  }
}
