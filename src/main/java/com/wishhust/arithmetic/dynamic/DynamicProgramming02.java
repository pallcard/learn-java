package com.wishhust.arithmetic.dynamic;

/**
 * 过桥
 */
public class DynamicProgramming02 {
  private int getMinTime(int [] T) {
    int n = T.length;
    int [] opt = new int[n];
    opt[0] = T[0];
    opt[1] = Math.max(T[0], T[1]);
    for (int i = 2; i < n; i++) {
      opt[i] = Math.min(opt[i-1]+T[0]+T[i], opt[i-2]+T[0]+T[i]+T[1]*2);
    }
    return opt[n-1];
  }

  public static void main(String[] args) {
    int minTime = new DynamicProgramming02().getMinTime(new int[]{1, 2, 5, 10});
    System.out.println(minTime);
  }
}
