package com.wishhust.findoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {
  public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    if (k > input.length) {
      return new ArrayList<>(k);
    }
    List<Integer> indexList = new ArrayList<>(k);
    ArrayList<Integer> result = new ArrayList<>(k);
    for (int i = 0; i < k; i++) {
      int min = Integer.MAX_VALUE;
      int minIndex = 0;
      for (int j = 0; j < input.length; j++) {
        if (!indexList.contains(j) && min > input[j]) {
          min = input[j];
          minIndex = j;
        }
      }
      indexList.add(minIndex);
      result.add(input[minIndex]);
    }
    return result;
  }

  public static void main(String[] args) {
    ArrayList<Integer> integers = new GetLeastNumbers()
        .GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
    System.out.println(integers);
  }
}
