package com.wishhust.arithmetic.leetcode;

/**
 * 最小路径和
 *
 * 给定一个二维数组m*n，计算从[0][0]到[m-1][n-1]的最短路径和
 *
 * 分析：
 * 最后达到[m-1][n-1]，可以自底向上分析,最终推到[0][0]
 *
 *  1, 3, 1
 *  1, 5, 1
 *  4, 2, 1
 *
 *  由于(i, j) 需要根据 (i-1, j), (i, j-1)来推出，
 *  最后一排只能由右边推出，最后一列只能由下边推出，其他需要根据右边和下边推出
 *  可以在最后加一排和一列，这样可以保证一致。
 *
 */


public class Leetcode64 {

    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][dp[0].length - 1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[dp.length - 1][i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j];
            }
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (i == dp.length - 2 && j == dp[0].length - 2) {
                    continue;
                }
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + dp[i][j];
            }
        }

        return dp[0][0];

    }

    public static void main(String[] args) {
        System.out.println(new Leetcode64().minPathSum(new int[][] {
//                {1,3,1},{1,5,1},{4,2,1}
                {1,2,5},{3,2,1}
        }));
    }


}
