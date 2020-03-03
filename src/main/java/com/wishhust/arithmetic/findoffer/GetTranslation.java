package com.wishhust.arithmetic.findoffer;

/**
 * 把数字翻译成字符串
 * 给定一个数字，按照如下规则翻译字符串：0翻译成'a',1翻译成'b',25翻译成'z', 输出字符可能翻译的方法数。
 *
 * 1. 分析
 * f(i) = f(i+1) + f(i+2)* 1  (i,i+1) 属于 [10, 25]
 *                       * 0  (i,i+1) 不属于 [10, 25]
 *
 *  例如：求 12258 --- (12属于) 2258   ---  258 --- 58 ---8
 *                  |                  |        --  8
 *                  |                  --  58  --- 8
 *                 |
 *                 --          258   --- 58
 *                                    --  8
 *  递归是自上而下，有很多重复的子问题，
 */
public class GetTranslation {
  public int GetTranslation(int num) {
    if (num < 10) {
      return 1;
    } else if (num <= 25) {
      return 2;
    } else if (num <= 100){
      return 1;
    }
    return getTranslation(String.valueOf(num));
  }

  public int getTranslation(String num) {
    int f1 = 1;
    int f2 = 0;
    int length = num.length();
    if (Integer.parseInt(num.substring(length-2, length)) <= 25) {
      f2 = 2;
    } else {
      f2 = 1;
    }
    for (int i = length-3; i >= 0;  i--) {
      if (Integer.parseInt(num.substring(i, i+2)) <= 25) {
        int temp = f1 + f2;
        f1= f2;
        f2 = temp;
      } else {
        f1 = f2;
      }
    }
    return f2;
  }

  public static void main(String[] args) {
    int i = new GetTranslation().GetTranslation(12258);
    System.out.println(i);

  }
}
