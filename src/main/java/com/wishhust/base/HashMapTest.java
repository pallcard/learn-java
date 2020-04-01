package com.wishhust.base;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

  public static void main(String[] args) {

//    Map<String, String> map = new HashMap<>();
//    map.put("1", "test1");
//    map.put("2", "test2");
//    map.put("3", "test3");
//    map.put("4", "test4");

    Map<HashMapTest, String> map2 = new HashMap<>();
    HashMapTest hashMapTest = new HashMapTest();

    map2.put(hashMapTest, "test1");
    map2.put(hashMapTest, "test2");
    System.out.println(map2.get(hashMapTest));
  }

}
