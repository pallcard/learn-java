package com.wishhust.findoffer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
  public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    ArrayList<Integer> ret = new ArrayList<>(2);
   int left = 0;
   int right = array.length-1;
   while (left < right) {
     if (array[left] + array[right] == sum) {
       ret.add(array[left]);
       ret.add(array[right]);
       return ret;
     } else if (array[left] + array[right] > sum) {
       right--;
     } else {
       left++;
     }
   }
   return ret;
  }
}
