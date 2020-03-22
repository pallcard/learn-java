package com.wishhust.arithmetic.dynamic;

public class DynamicProgramming04 {
  public int getMax(int [] arr) {
    int opt [] = new int [arr.length];
    opt[0] = arr[0];
    opt[1] = Math.max(arr[0], arr[1]);

    for (int i = 2; i < arr.length; i++) {
      opt[i] = Math.max(opt[i-2]+arr[i], opt[i-1]);
    }

    return opt[arr.length-1];
  }

  public static void main(String[] args) {
//    int max = new DynamicProgramming04().getMax(new int[]{1,2,4,1,7,8,3});
    int max = new DynamicProgramming04().getMax(new int[]{4,1,1,9,1});
    System.out.println(max);
  }
}
