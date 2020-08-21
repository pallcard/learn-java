package com.wishhust.arithmetic.leetcode;

public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 从右上角开始查询
        if (matrix.length <= 0) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (target > matrix[x][y]) {
                x++;
            } else if (target < matrix[x][y]) {
                y--;
            } else {
                return true;
            }
        }
        return false;
    }

}
