package com.wishhust.arithmetic.dynamic;

public class DynamicProgramming06 {

  public static void main(String[] args) {
    int max = new DynamicProgramming06().getMax(new int[][]{{1,4,5}, {3,5,1}, {0,6,8} ,{4,7,4},{3,8,6},{5,9,3},{6,10,2},{8,11,4}});
    System.out.println(max);
  }

  private int getMax(int[][] work) {
    // 按结束时间排序，已排好
    int [] opt = new int[work.length];
    int [] pre = new int[work.length];

    for (int i = work.length-1; i >= 0; i--) {
      int j = i - 1;
      for (; j >= 0 && work[j][1]>work[i][0] ; j--) {

      }
      pre[i] = j;
    }

    opt[0] = work[0][2];

    for (int i = 1; i < work.length; i++) {
      if (pre[i] >= 0) {
        opt[i] = Math.max(opt[pre[i]]+work[i][2], opt[i-1]);
      } else {
        opt[i] = Math.max(opt[i-1], work[i][2]);
      }
    }
    return opt[work.length-1];
  }


}
