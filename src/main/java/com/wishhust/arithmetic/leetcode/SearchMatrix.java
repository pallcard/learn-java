package com.wishhust.arithmetic.leetcode;

/**
 * Created by liuke on 2019/12/18 20:50
 *
 * <p>搜索二维矩阵 II
 *
 * <p>编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * <p>每行的元素从左到右升序排列。 每列的元素从上到下升序排列。 示例:
 *
 * <p>现有矩阵 matrix 如下：
 *
 * <p>[ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21,
 * 23,26, 30] ]
 *
 * <p>给定 target = 5，返回 true。 给定 target = 20，返回 false。
 */
public class SearchMatrix {
  public static boolean result = false;

  public boolean searchMatrix(int[][] matrix, int target) {
    dfsSearch(matrix, 0, 0, target);
    return result;
  }

  public boolean searchMatrix2(int[][] matrix, int target) {
    int m = 0;
    if (matrix.length == 0) {
      return false;
    }
    int n = matrix[0].length - 1;
    while (m < matrix.length && n >= 0) {

      if (matrix[m][n] == target) {
        return true;
      } else if (matrix[m][n] < target) {
        m++;
      } else {
        n--;
      }
    }
    return false;
  }

  public void dfsSearch(int[][] matrix, int x, int y, int target) {
    if (matrix[x][y] == target) {
      result = true;
    } else if (matrix[x][y] < target) {
      if (y + 1 < matrix[0].length) {
        dfsSearch(matrix, x, y + 1, target);
      }
      if (x + 1 < matrix.length) {
        dfsSearch(matrix, x + 1, y, target);
      }
    }
  }

  public static void main(String[] args) {
    SearchMatrix searchMatrix = new SearchMatrix();
    boolean b =
        searchMatrix.searchMatrix2(
            new int[][] {
              {1, 4, 7, 11, 15},
              {2, 5, 8, 12, 19},
              {3, 6, 9, 16, 22},
              {10, 13, 14, 17, 24},
              {18, 21, 23, 26, 30}
            },
            40);
    System.out.println(b);
  }
}
