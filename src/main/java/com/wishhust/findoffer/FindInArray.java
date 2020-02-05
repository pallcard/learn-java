package com.wishhust.findoffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class FindInArray {
  public boolean find(int target, int [][] array) {
    int lineCount = array[0].length;
    int rowCount = array.length;
    int x = 0;
    int y = lineCount-1;
    while (x < rowCount && y >= 0) {
      if (array[x][y] == target) {
        return true;
      } else if (array[x][y] > target) {
        y--;
      } else {
        x++;
      }
    }
    return false;
  }
}
