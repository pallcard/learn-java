package com.wishhust.interview.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo02 {

  public static int getSubArrays(int[] nums){
    int count = (int)Math.pow(2,nums.length);
    int ret = 0;
    for(int i=1;i<count-1;i++){
      List<Integer> subarray = new ArrayList<>();
      int temp = i;
      int index = 0;
      boolean flag = true;
      while (temp!=0){
        if((temp&1)==1){
          if (nums[index]%(subarray.size()+1) == 0) {
            subarray.add(nums[index]);
          } else {
            flag = false;
            break;
          }
        }
        index++;
        temp = temp >>1;
      }
      if (subarray.size()>0 && flag) {
        ret++;
      }
    }
    return ret;
  }

  public static List getSubArrays2(int[] nums){
    int count = (int)Math.pow(2,nums.length);
    List<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
    for (int i = 1; i < count - 1; i++) {
      List<Integer> subarray = new ArrayList<Integer>();
      int temp = i;
      int index = 0;
      while (temp != 0) {
        if ((temp & 1) == 1) {
          subarray.add(nums[index]);
        }
        index++;
        temp = temp >> 1;
      }
      arrays.add((ArrayList<Integer>) subarray);
    }
    return arrays;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int [] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    Arrays.sort(arr);

    int ret = getSubArrays(arr);

    System.out.println(ret);
  }
}
