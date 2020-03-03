package com.wishhust.arithmetic.findoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
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

  private static ArrayList<Integer> list = new ArrayList<>();

  public void GetLeastNumbers_Solution2(int [] input, int start, int end, int k) {
    if (k > end-start+1) {
      return;
    }
    int partition = partition(input, start, end);
    if (k == partition-start+1) {
      // 输出 start, partition
      for (int i = start; i <= partition; i++) {
        list.add(input[i]);
      }
    } else if (k < partition-start+1) {
      // 右边舍弃
      GetLeastNumbers_Solution2(input, start, partition, k);
    } else {
      // 左边加入
      for (int i = start; i <= partition; i++) {
        list.add(input[i]);
      }
      GetLeastNumbers_Solution2(input, partition, end, k-(partition-start+1));
    }
  }

  int partition(int [] data, int start, int end) {
    if (null == data || data.length <= 0 || start < 0 || end >=data.length) {
      return -1;
    }
//    int index = new Random().nextInt(end-start)+start;
    int index;
    // 以end为分界点
//    swap(data, index, end);
    int small = start-1;
    for (index = start; index < end; ++index) {
      if (data[index] < data[end]) {
        small++;
        if (small != index) {
          swap(data, index, small);
        }
      }
    }
    small++;
    swap(data, small, end);
    return small;
  }

  public ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {
    if (k > input.length) {
      return new ArrayList<>(k);
    }
    TreeSet<Integer> treeSet = new TreeSet<>();

    for (int i = 0; i < input.length; i++) {
      if (treeSet.size() < k) {
        treeSet.add(input[i]);
      } else if (treeSet.first() < input[i]) {
        treeSet.remove(treeSet.last());
        treeSet.add(input[i]);
      }
    }
    return (ArrayList<Integer>) treeSet.stream().collect(Collectors.toList());
  }

  private void swap(int [] array, int x, int y) {
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }

  public static void main(String[] args) {
    int [] array = new int[]{4,1,5,8,2,3};
    ArrayList<Integer> integers = new GetLeastNumbers()
        .GetLeastNumbers_Solution(array, 4);
    System.out.println(integers);
//    int partition = new GetLeastNumbers().partition(array, 0, 0);
//    System.out.println(partition);
    new GetLeastNumbers().GetLeastNumbers_Solution2(array, 0, array.length-1, 3);
    System.out.println(list);

    array = new int[]{4,1,5,8,2,3};
    ArrayList<Integer> integers2 = new GetLeastNumbers().GetLeastNumbers_Solution3(array, 3);
    System.out.println(integers2);
  }
}
