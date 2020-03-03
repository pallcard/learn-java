package com.wishhust.arithmetic.findoffer;

import java.util.ArrayList;

public class PrintMatrix {
  public ArrayList<Integer> printMatrix(int [][] matrix) {
    ArrayList<Integer> list = new ArrayList<>();
    int row = matrix.length;
    int line = matrix[0].length;
    boolean [][] isVisited = new boolean[row][line];
    int count = row * line;
    int cur_x = 0;
    int cur_y = 0;
    list.add(matrix[cur_x][cur_y]);
    isVisited[cur_x][cur_y] = true;
    count--;
    while (count > 0) {
      // right
      while (cur_y+1 < line && !isVisited[cur_x][cur_y+1]) {
        cur_y++;
        list.add(matrix[cur_x][cur_y]);
        isVisited[cur_x][cur_y] = true;
        count--;
      }
      // down
      while (cur_x+1 < row && !isVisited[cur_x+1][cur_y]) {
        cur_x++;
        list.add(matrix[cur_x][cur_y]);
        isVisited[cur_x][cur_y] = true;
        count--;
      }
      // left
      while (cur_y-1 >= 0 && !isVisited[cur_x][cur_y-1]) {
        cur_y--;
        list.add(matrix[cur_x][cur_y]);
        isVisited[cur_x][cur_y] = true;
        count--;
      }
      // up
      while (cur_x-1 >= 0 && !isVisited[cur_x-1][cur_y]) {
        cur_x--;
        list.add(matrix[cur_x][cur_y]);
        isVisited[cur_x][cur_y] = true;
        count--;
      }
    }
    return list;
  }

  public static void main(String[] args) {
    new PrintMatrix().printMatrix(new int[][]{{1}});
  }
}
