package com.wishhust.interview.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo01 {
  private static int []q = new int[]{4, 9};

  public static List<Integer> list = new ArrayList<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    if (n < 4) {
      System.out.println(-1);
      return;
    }
    int count = 0;
    dps(n, count);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < list.size(); i++) {
      if (min > list.get(i)) {
        min = list.get(i);
      }
    }
    if (min == Integer.MAX_VALUE) {
      System.out.println(-1);
      return;
    }
    System.out.println(min);
  }

  private static void dps (int n, int count) {
    if (n < 0) {
      return;
    }
    if (n == 0) {
      list.add(count);
      return;
    }
    for (int i = 0; i < q.length; i++) {
      dps(n-q[i], count+1);
    }
  }
}
