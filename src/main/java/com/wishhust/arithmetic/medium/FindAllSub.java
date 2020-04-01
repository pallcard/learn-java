package com.wishhust.arithmetic.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllSub {

  public static void main(String[] args) {
    List<List<Integer>> list = getSubArr(new int[] {1,2,3});
    System.out.println(list);

    List<List<Integer>> list2 = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    dfs(0, new int[]{1,2,3}, sub, list2);
    System.out.println(list2);
  }

  private static List<List<Integer>> getSubArr(int[] arr) {
    List<List<Integer>> list = new ArrayList<>();
    int count = 1 << arr.length;

    for (int i = 0; i < count; i++) {
      List<Integer> sub = new ArrayList<>();
      for (int j = 0; j < arr.length; j++) {
        if (((1 << j) & i) != 0) {
          sub.add(arr[j]);
        }
      }
      list.add(sub);
    }
    return list;
  }

  public static void dfs(int i, int [] nums, List<Integer> sub, List<List<Integer>> list) {
    list.add(new ArrayList<>(sub));
    if (i >= nums.length) {
      return;
    }
    for (int j = i; j < nums.length; j++) {
      sub.add(nums[j]);
      dfs(j+1, nums, sub, list);
      sub.remove(sub.size()-1);
    }
  }

}
