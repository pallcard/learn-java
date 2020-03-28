package com.wishhust.interview.langchao;

import java.util.Scanner;

public class Test01 {

  public static int max = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int [] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    dps(arr, 1, arr[0],0);
    dps(arr, 1, 1,0);
    System.out.println(max);
  }

  private static void dps(int[] arr, int step, int pre, int temp) {
    if (step == arr.length) {
      temp += Math.abs(arr[step-1]-pre);
      if (max < temp) {
        max = temp;
      }
      return;
    }
    int arrTemp = Math.abs(arr[step]-pre);
    dps(arr, step+1, arr[step], temp+arrTemp);
    if (arr[step] != 1) {
      arrTemp = Math.abs(1-pre);
      dps(arr, step+1, 1, temp+arrTemp);
    }

  }


}
