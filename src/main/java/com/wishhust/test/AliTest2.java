package com.wishhust.test;

import java.util.Scanner;

public class AliTest2 {

  // 输入为1-10的个数
  // 有四种出牌方式
  // 1. 单牌
  // 2. 3连对
  // 3. 对子
  // 4. 5连顺
  // 输入 1 1 1 2 2 2 2 2 1 1
  // 输出 3

  private static int min = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] card = new int[10];
    int i = 0;
    String[] s = sc.nextLine().split(" ");
    for (String str : s) {
      card[i] = Integer.parseInt(str);
      // 初始化为最大值
      min += card[i];
      i++;
    }
    int times = 0;
    dfs(card, times);
    System.out.println(min);
  }

  private static void dfs(int[] card, int times) {
    if (times > min) {
      return;
    } else {
      int sum = 0;
      for (int i = 0; i < 10; i++) {
        sum += card[i];
      }
      if (sum == 0 && times < min) {
        min = times;
        return;
      }

    }
    for (int i = 0; i < 4; i++) {
      switch (i) {
        // 连对
        case 0:
          for (int j = 0; j < 8; j++) {
            if (card[j] >= 2 && card[j + 1] >= 2 && card[j + 2] >= 2) {
              // 打出连对
              card[j] -= 2;
              card[j + 1] -= 2;
              card[j + 2] -= 2;
              dfs(card, times + 1);
              card[j] += 2;
              card[j + 1] += 2;
              card[j + 2] += 2;
            }
          }
          break;
        // 顺子
        case 1:
          for (int j = 0; j < 6; j++) {
            if (card[j] >= 1 && card[j + 1] >= 1 && card[j + 2] >= 1 && card[j + 3] >= 1
                && card[j + 4] >= 1) {
              // 打出连对
              card[j] -= 1;
              card[j + 1] -= 1;
              card[j + 2] -= 1;
              card[j + 3] -= 1;
              card[j + 4] -= 1;
              dfs(card, times + 1);
              card[j] += 1;
              card[j + 1] += 1;
              card[j + 2] += 1;
              card[j + 3] += 1;
              card[j + 4] += 1;
            }
          }
          break;
        //对子
        case 2:
          for (int j = 0; j < 10; j++) {
            if (card[j] >= 2) {
              card[j] -= 2;
              dfs(card, times + 1);
              card[j] += 2;
            }
          }
          break;
        // 单牌
        case 3:
          for (int j = 0; j < 10; j++) {
            if (card[j] >= 1) {
              card[j] -= 1;
              dfs(card, times + 1);
              card[j] += 1;
            }
          }
          break;
      }
    }
  }


}
