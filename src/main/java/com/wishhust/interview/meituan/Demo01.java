package com.wishhust.interview.meituan;

import java.math.BigDecimal;
import java.util.Scanner;

public class Demo01 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    double sum = 0.0;
    int pre = 0;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        int c = scanner.nextInt();
        sum += Math.PI * c * c - Math.PI * pre * pre;
      } else {
        pre = scanner.nextInt();
      }
    }
    BigDecimal bg = new BigDecimal(sum);
    double f1 = bg.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
    System.out.println(f1);
  }
}
