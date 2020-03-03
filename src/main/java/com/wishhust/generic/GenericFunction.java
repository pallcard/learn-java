package com.wishhust.generic;

public class GenericFunction {
  public <T> void test(T t) {
    System.out.println(t);
  }

  public static void main(String[] args) {
    new GenericFunction().test(new String("test"));
  }
}
