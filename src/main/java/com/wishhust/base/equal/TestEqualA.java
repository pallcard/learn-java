package com.wishhust.base.equal;

import java.util.HashSet;

public class TestEqualA {

//  @Override
//  public int hashCode() {
//    return 1;
//  }

  @Override
  public boolean equals(Object obj) {
    return true;
//    return super.equals(obj);
  }

  public static void main(String[] args) {
    String aa = new String("aa");
    String aa2 = new String("aa");
    System.out.println(aa.hashCode());
    System.out.println(aa2.hashCode());
    System.out.println(aa2==aa);
    System.out.println(aa.equals(aa2));
    TestEqualA testEqualA = new TestEqualA();
    TestEqualB testEqualB = new TestEqualB();
    System.out.println(testEqualB.hashCode());
    System.out.println(testEqualA.equals(testEqualB));

    HashSet<Object> objects = new HashSet<>();
    objects.add(testEqualA);
    objects.add(testEqualB);
    System.out.println(objects.size());

  }
}
