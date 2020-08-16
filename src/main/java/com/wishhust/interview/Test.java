package com.wishhust.interview;

import java.util.Scanner;

public class Test {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int base = scanner.nextInt();

    int co = base + (n*(n/2))+n/2;
    co *= (n*2);
    System.out.println(co);



  }
}
