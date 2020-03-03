package com.wishhust.arithmetic.findoffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 *
 */
public class MaxInWindows {
  public ArrayList<Integer> maxInWindows(int [] num, int size) {
    int start = 0;
    int end = size-1;
    if (size == 0) {
      return new ArrayList<>();
    }

    ArrayList<Integer> ret = new ArrayList<>();
    for (; end < num.length; ) {
      ret.add(findMax(num, start, end));
      start++;
      end++;
    }

    return ret;
  }

  private int findMax(int [] num, int start, int end) {
    int max = Integer.MIN_VALUE;
    for (int i = start; i <= end; i++) {
      if (num[i] > max) {
        max = num[i];
      }
    }
    return max;
  }

//   2 3 4 2 6 2 5 1
  public ArrayList<Integer> maxInWindows2(int [] num, int size) {
    if (size <= 0 || num.length == 0 || num.length < size){
      return new ArrayList<>();
    }
    ArrayList<Integer> ret = new ArrayList<>();
    if (size == 1) {
      for (int i = 0; i < num.length; i++) {
        ret.add(num[i]);
      }
      return ret;
    }
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(0);
    int index = 1;
    for (; index < size && index < num.length; index++) {
      if (num[index] > num[queue.peek()]) {
        queue.clear();
      }
      queue.add(index);
    }

    ret.add(num[queue.peek()]);
    for (; index < num.length; index++) {
      if (index - queue.peek() >= size) {
        queue.poll();
      }
      if(num[queue.peek()] > num[index]) {
        while (num[queue.getLast()] <= num[index]) {
          queue.removeLast();
        }
        ret.add(num[queue.peek()]);
      }  else {
        queue.clear();
        ret.add(num[index]);
      }
      queue.add(index);
    }
    return ret;
  }

  public static void main(String[] args) {
    ArrayList<Integer> integers = new MaxInWindows().maxInWindows2(new int[]{16,14,12,10,8,6,4}, 1);
    System.out.println(integers);
  }

}
