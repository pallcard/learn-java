package com.wishhust.effective;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionClassifier {

  public static String classfiy(Set<?> s) {
    return "set";
  }

  public static String classfiy(List<?> lst) {
    return "list";
  }

  public static String classfiy(Collection<?> c) {
    return "unKnow Collection";
  }

  public static void test(String str) {
    System.out.println("string");
  }

  public static void test(Object obj) {
    System.out.println("object");
  }
  public static void test2(Set<?> set) {
    System.out.println("set");
  }
  public static void test2(Collection<?> c) {
    System.out.println("Collection");
  }

  public static void main(String[] args) {
    Collection<?>[] collections = {new HashSet<>(), new ArrayList<>(),
        new HashMap<String, String>().values()};
    for (Collection<?> c : collections) {
      System.out.println(classfiy(c));
    }
    System.out.println("--------------");
    System.out.println(classfiy(new HashSet<>()));
    System.out.println(classfiy(new ArrayList<>()));
    System.out.println(classfiy(new HashMap<String, String>().values()));

    System.out.println("--------------test");
    test("1111");
    test(new Object());

    System.out.println("--------------test2");
    test2(new HashSet<>());

  }

}
