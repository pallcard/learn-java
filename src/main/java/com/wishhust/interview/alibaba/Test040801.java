package com.wishhust.interview.alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class Test040801 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int i = 0; i < T; i--) {
      for (int j = 0; j < 4; j++) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result = fun(n, m, a, b);
        System.out.println(result);
      }
    }
  }
  // n 时间   5
  // m 木头人数  5
  // b 范围  2
  // a 血   2
  private static int fun(int n, int m, int a, int b) {
    if (n < a) {
      return 0;
    }

    int [] arrm = new int[m];

    for (int i = 0; i < m; i++) {
      arrm[i] = a;
    }

    Arrays.sort(arrm);

    int index = arrm.length;

    for (int i = 0; i < n; i++) {

      for (int j = 0; j < b; j++) {
        if (index-j-1 >= 0) {
          arrm[index-j-1] -= 1;
        } else {
          index = index-j-1;
        }
      }
      Arrays.sort(arrm);
    }
    int count = 0;

    for (int i = 0; i < arrm.length; i++) {
      if (arrm[i]<=0) {
        count++;
      }
    }

    return count;

  }

}
