package com.wishhust.interview.zcliantong;

import java.util.Scanner;

public class Test02 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    String[] split = str.split(",");
    String[] s = split[0].split(" ");

    int target = Integer.parseInt(split[1]);
    int left = 0;
    int right = s.length-1;
    while (left <= right) {
      int mid = (left+right)/2;
      if(Integer.parseInt(s[mid]) == target) {
        System.out.println(mid);
        return;
      } else if(Integer.parseInt(s[mid]) < target) {
        left = mid+1;
      } else {
        right = mid-1;
      }
    }
    System.out.println(-1);
  }
}
