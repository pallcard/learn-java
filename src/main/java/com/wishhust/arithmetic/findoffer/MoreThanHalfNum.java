package com.wishhust.arithmetic.findoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 */
public class MoreThanHalfNum {
  public int MoreThanHalfNum_Solution(int [] array) {
    int count = array.length/2;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      int temp = 0;
      if (!map.containsKey(array[i])) {
        temp = 1;
        map.put(array[i], 1);
      } else {
        temp = map.get(array[i])+1;
        map.put(array[i],temp);
      }
      if (temp > count) {
        return array[i];
      }
    }
    return 0;
  }
  public int MoreThanHalfNum_Solution2(int [] array) {
    int count = 1;
    int cur_num = array[0];
    for (int i = 1; i < array.length; i++) {
      if (count == 0) {
        cur_num = array[i];
      }
      if (cur_num == array[i]) {
        count++;
      } else {
        count--;
      }

    }
    int curNumCount = 0;
    for (int i = 0; i < array.length; i++) {
      if (cur_num == array[i]) {
        curNumCount++;
      }
    }
    if (curNumCount > array.length/2) {
      return cur_num;
    } else {
      return 0;
    }
  }


  public static void main(String[] args) {
    int i = new MoreThanHalfNum().MoreThanHalfNum_Solution2(new int[]{1,2,3,2,2,2,5,4,2});
    System.out.println(i);
  }
}
