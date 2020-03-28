package com.wishhust.interview.zcliantong;

import java.util.Scanner;

public class Test03 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    StringBuilder sb = new StringBuilder(str);
    for (int i = 0; i < str.length(); i++) {
      int a = (str.charAt(i)-'0')^30000;
    }
    System.out.println(sb);
    System.out.println(20%-14);
  }
}
