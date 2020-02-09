package com.wishhust.findoffer;

public class InversePairs {
  public int InversePairs(int [] array) {
    int index = array.length-1;
    int count = 0;
    for (; index > 0; index--) {
      for (int i = index-1; i >= 0; i--) {
        if (array[i] > array[index]) {
          count++;
        }
      }
    }
    return count;
  }
}
