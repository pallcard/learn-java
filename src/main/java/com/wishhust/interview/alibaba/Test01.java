package com.wishhust.interview.alibaba;

/**
 * n个数，m次，增量k
 * n个数每次增加k，然后最大的数 max/2，m次之后数组和为多少？
 */

import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int k = scanner.nextInt();
    int [] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    for (int i = 0; i < m; i++) {
      arr[0] += k;
      int max = arr[0];
      int maxIndex = 0;
      for (int j = 1; j < n; j++) {
        if ((arr[j]= arr[j]+k) > max) {
          maxIndex = j;
          max = arr[j];
        }
      }
      arr[maxIndex] /= 2;
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }
    System.out.println(sum);


  }
}
