package com.wishhust.interview.yidong;

import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int [] te = new int[4];
    for (int i = 0; i < 4; i++) {
      te[i] = scanner.nextInt();
    }
    int c = Math.max(te[0], te[1]);
    int h = Math.min(te[2], te[3]);
    if (c <= h) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }

  }
}
