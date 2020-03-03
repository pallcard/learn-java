package com.wishhust.arithmetic.findoffer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如
 * ​a b c e
 *  s f c s
 *  a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class MatrixHasPath {

  public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
  {
    char [][] matrixArray = new char[rows][cols];
    int index = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrixArray[i][j] = matrix[index++];
      }
    }
    return hasPath(matrixArray, str);
  }

  public boolean hasPath(char[][] matrix, char[] str) {
    if (null == str || str.length == 0) {
      return false;
    }
    int [] startRow = new int[matrix.length*matrix[0].length];
    int startRowIndex = 0;
    int [] startCol = new int[matrix.length*matrix[0].length];
    int startColIndex = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == str[0]) {
          startRow[startRowIndex++] = i;
          startCol[startColIndex++] = j;
        }
      }
    }

    for (int i = 0; i < startRowIndex; i++) {
      boolean [][] isVisited = new boolean[matrix.length][matrix[0].length];
      isVisited[startRow[i]][startCol[i]] = true;
      dfs(matrix, str, startRow[i], startCol[i], 1, isVisited);
      if (hasPath) {
        return true;
      }
    }
    return false;
  }

  private int [] directX = new int[]{1, 0, -1, 0};
  private int [] directY = new int[]{0, 1, 0, -1};
  private boolean hasPath = false;

  private void dfs(char[][] matrix, char[] str, int x, int y, int step, boolean [][] isVisited) {
    if (step == str.length) {
      hasPath =  true;
      return;
    }
    for (int i = 0; i < 4; i++) {
      x += directX[i];
      y += directY[i];
      if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !isVisited[x][y] && matrix[x][y] == str[step]) {
        isVisited[x][y] = true;
        dfs(matrix, str, x, y, step+1, isVisited);
        if (hasPath) {
          return;
        }
        isVisited[x][y] = false;
      }
      x -= directX[i];
      y -= directY[i];
    }
  }

  public static void main(String[] args) {
    boolean hasPath = new MatrixHasPath().hasPath("AAAAAAAAAAAA".toCharArray(), 3, 4, "AAAAAAAAAAAA".toCharArray());
    System.out.println(hasPath);
  }
}
