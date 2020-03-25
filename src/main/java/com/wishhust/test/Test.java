package com.wishhust.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuke on 2019/12/18 16:08
 */
public class Test {
  public static void main(String[] args) {
    System.out.println("中文");


    Map<String, Double> map = new HashMap<>();
    map.put("k1", 1.0);

    String a = "￥";
    System.out.println(a.length());

    System.out.println(Character.MAX_RADIX);
    System.out.println(Integer.MAX_VALUE + "" + Integer.MIN_VALUE);
  }
}
