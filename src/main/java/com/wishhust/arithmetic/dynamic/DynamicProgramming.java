package com.wishhust.arithmetic.dynamic;

/**
 * 现在有面值 1，5，11的钞票，求最少拼出15所用的钞票数。
 */
public class DynamicProgramming {

  public int getMinMoneyCount01(int w) {
    if (w < 0) {
      return Integer.MAX_VALUE;
    }
    if (w == 0) {
      return 0;
    }
    if (w == 1 || w == 5 || w == 11) {
      return 1;
    }
    return Math.min(Math.min(getMinMoneyCount01(w - 1), getMinMoneyCount01(w - 5)),
        getMinMoneyCount01(w - 11)) + 1;
  }

  private int [] r = new int[16];
  // 自顶向下，备忘录
  // 上述算法会出现很多重复的。
  public int getMinMoneyCount02(int w) {
    if (w < 0) {
      return Integer.MAX_VALUE;
    }
    if (r[w] > 0) {
      return r[w];
    }
    if (w == 0) {
      return 0;
    }
    if (w == 1 || w == 5 || w == 11) {
      return 1;
    }
    r[w] = Math.min(Math.min(getMinMoneyCount02(w - 1), getMinMoneyCount02(w - 5)),
        getMinMoneyCount02(w - 11)) + 1;
    return r[w];
  }

  // 自底向上
  public int getMinMoneyCount03(int w) {
    int [] dp = new int[w+1];
    dp[1] = 1;
    dp[5] = 1;
    dp[11] = 1;
    for (int i = 2; i <= w; i++) {
      int min = Integer.MAX_VALUE;
      if (i >= 5) {
        min = Math.min(dp[i-1],dp[i-5]);
      }
      if (i >= 11) {
        min = Math.min(min, dp[i-11]);
      }
      dp[i] = Math.min(dp[i-1], min)+1;
    }
    return dp[w];
  }

  public static void main(String[] args) {
    // 直接递归
    int minMoneyCount01 = new DynamicProgramming().getMinMoneyCount01(15);
    System.out.println(minMoneyCount01);

    // 自顶向下，备忘录
    int minMoneyCount02 = new DynamicProgramming().getMinMoneyCount02(15);
    System.out.println(minMoneyCount02);

    // 自底向上
    int minMoneyCount03 = new DynamicProgramming().getMinMoneyCount03(15);
    System.out.println(minMoneyCount03);
  }

}
