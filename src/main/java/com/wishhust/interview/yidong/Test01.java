package com.wishhust.interview.yidong;

import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < 4; i++) {
      int n = scanner.nextInt();
      if (n < min) {
        min = n;
      }
    }
    System.out.println(min);
  }
}
