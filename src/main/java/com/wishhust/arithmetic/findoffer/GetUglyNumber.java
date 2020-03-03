package com.wishhust.arithmetic.findoffer;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 */
public class GetUglyNumber {

  public static void main(String[] args) {
    int i = new GetUglyNumber().GetUglyNumber_Solution2(2);
    System.out.println(i);
  }
  public int GetUglyNumber_Solution(int index) {
    int num = 0;
    do {
      num++;
      if (isUglyNumber(num)) {
        index--;
      }
    }while (index>0);

    return num;
  }

  public int GetUglyNumber_Solution2(int index) {
    if (index == 0) {
      return 0;
    }

    int [] res = new int[index];
    res[0] = 1;
    int p2 = 0;
    int p3 = 0;
    int p5 = 0;
    for (int i = 1; i < index; i++) {
      res[i] = Math.min(Math.min(res[p2]*2, res[p3]*3), res[p5]*5);
      if (res[i] == res[p2]*2) {
        p2++;
      }
      if (res[i] == res[p3]*3) {
        p3++;
      }
      if (res[i] == res[p5]*5) {
        p5++;
      }
    }
    return res[index-1];
  }


  private boolean isUglyNumber(int n) {
    boolean flag = true;
    while (n > 1 && flag) {
      flag = false;
      if (n % 2 == 0) {
        n /= 2;
        flag = true;
      }
      if (n % 3 == 0) {
        n /= 3;
        flag = true;
      }
      if (n % 5 == 0) {
        n /= 5;
        flag = true;
      }
    }
    return n == 1;
  }

}
