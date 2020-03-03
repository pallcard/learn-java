package com.wishhust.arithmetic.findoffer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 1. 不能直接遍历整个方格，要保证与(0,0)是连通的
 */
public class RobotMovingCount {
  private int count = 0;
  public int movingCount(int threshold, int rows, int cols) {
    count = 1;
    boolean[][] isVisited = new boolean[rows][cols];
    isVisited[0][0] = true;
    dfs(rows,cols,threshold,0,0, isVisited);
    return count;
  }

  private int[] directX = new int[]{0,1};
  private int[] directY = new int[]{1,0};

  private void dfs(int rows, int cols, int threshold, int x, int y, boolean[][] isVisited) {
    for (int i = 0; i < 2; i++) {
      int nextX = x+directX[i];
      int nextY = y+directY[i];
      if (nextX>=0 && nextX < rows && nextY>=0 && nextY<cols && !isVisited[nextX][nextY] && add(nextX,nextY)<=threshold) {
        dfs(rows,cols,threshold,nextX,nextY, isVisited);
        count++;
      }
    }
  }

  public int movingCount2(int threshold, int rows, int cols) {
    boolean[][] isVisited = new boolean[rows][cols];
    return dfs2(rows,cols,threshold,0,0, isVisited);
  }

  private int dfs2(int rows, int cols, int threshold, int x, int y, boolean[][] isVisited) {
    if (x<0 || x >= rows || y<0 || y>=cols || isVisited[x][y] || add(x,y)>threshold) {
      return 0;
    }
    isVisited[x][y] = true;
    return dfs2(rows,cols,threshold,x+1,y, isVisited) + dfs2(rows,cols,threshold,x,y+1, isVisited)+1;
  }

  private int add(int x, int y) {
    int sum = 0;
    while (x / 10 != 0) {
      sum += (x % 10);
      x /= 10;
    }
    sum+=x;
    while (y / 10 != 0) {
      sum += (y % 10);
      y /= 10;
    }
    sum += y;

    return sum;
  }

  public static void main(String[] args) {
    int count = new RobotMovingCount().movingCount2(10, 1, 100);
    System.out.println(count);
  }

}
