package com.wishhust.interview.alibaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 一个数组的所有子序列中，最大数的期望
 */

public class Test02 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int [] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    Map<Integer, Integer> map= getSubArray(arr);
    double a = 0 ;
    for(Map.Entry<Integer,Integer> m :map.entrySet())
      a += m.getKey() * m.getValue();
    System.out.println(a/(Math.pow(2, arr.length)-1));
  }

  private static Map<Integer,Integer> getSubArray(int [] arr) {
    int count = (int) Math.pow(2, arr.length);
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 1; i < count; i++) {
      List<Integer> sub = new ArrayList<>();
      int temp = i;
      int index = 0;
      while (temp != 0) {
        if((temp & 1) == 1) {
          sub.add(arr[index]);
        }

        index++;
        temp = temp >> 1;
      }
      int count2 = 0;
      if (map.containsKey(sub.get(sub.size()-1))) {
        count2 = map.get(sub.get(sub.size()-1));
        map.put(sub.get(sub.size()-1), count2+1);
      } else {
        map.put(sub.get(sub.size()-1), 1);
      }
    }
    return map;
  }



}
