package com.wishhust.interview.zcliantong;

import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str1 = scanner.nextLine();
    String str2 = scanner.nextLine();

    int count = 0;
    int index = 0;
    while ((index = str1.indexOf(str2)) >= 0) {
      count++;
      str1 = str1.substring(index + str2.length());
    }
    System.out.println(count);
  }
}
