package com.wishhust.findoffer;

/**
 * 把某股票的价格按照时间先后顺序存储在数组中，请问该股票一次的最大利润是多少？
 * 例如： 9, 11, 8, 5, 7, 12, 16, 14
 * 价格为5时买进，16卖出，利润为11
 */
public class MaxDiff {
  int maxDiff(int [] num) {
    if (num.length <= 1) {
      return 0;
    }
    int min = num[0];
    int max = num[1] - num[0];
    for (int i = 2; i < num.length; i++) {
      if (num[i-1] < min) {
        min = num[i-1];
      }

      max = Math.max(num[i] - min, max);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(new MaxDiff().maxDiff(new int[]{9, 8, 5, 4, 3}));
  }
}
