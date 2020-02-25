package com.wishhust.findoffer;

/**
 * 礼物的最大价值
 *
 * 第i,j格的最大值为dp[i][j]
 * dp[i][j] = max( dp[i-1][j] + dp[i][j-1] ) + array[i][j];
 */
public class GetMaxValue {
  int getMaxValue(int [][] array) {
    int row = array.length;
    int cols = array[0].length;
    int [][] dp = new int[row][cols];

    dp[0][0] = array[0][0];
    for (int i = 1; i < row; i++) {
      dp[i][0] = array[i][0]+array[i-1][0];
    }
    for (int i = 1; i < cols; i++) {
      dp[0][i] = array[0][i]+array[0][i-1];
    }

    for (int i = 1; i < row; i++) {
      for (int j = 1; j < cols; j++) {
        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+array[i][j];
      }
    }
    return dp[row-1][cols-1];
  }

  int getMaxValue2(int [][] array) {
    int row = array.length;
    int cols = array[0].length;

    int [] maxValues = new int[cols];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < cols; j++) {
        int left = 0;
        int up = 0;
        if (i>0) {
          up = maxValues[j];
        }
        if (j>0) {
          left = maxValues[j-1];
        }
        maxValues[j] = Math.max(left, up)+array[i][j];
      }
    }
    return maxValues[cols-1];
  }

  public static void main(String[] args) {
    int maxValue = new GetMaxValue()
        .getMaxValue(new int[][]{{1, 10, 3, 8},
            {12, 2, 9, 6},
            {5, 7, 4, 11},
            {3, 7, 16, 5}});
    System.out.println(maxValue);
  }
}
