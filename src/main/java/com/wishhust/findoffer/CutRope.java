package com.wishhust.findoffer;



/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {

  public int cutRope(int target) {
    if (target < 2) {
      return 0;
    } else if (target == 2) {
      return 1;
    } else if (target == 3) {
      return 2;
    }

    int [] dp = new int[target+1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    for (int i = 4; i <= target; i++) {
      int max = 0;
      for (int j = 1; j <= i / 2; j++) {
        if (max < dp[j]*dp[i-j]) {
          max = dp[j]*dp[i-j];
        }
      }
      dp[i] = max;
    }
    return dp[target];
  }

  // 当绳长>=5时，尽可能分成3的部分
  public int cutRope2(int target) {
    if (target < 2) {
      return 0;
    } else if (target == 2) {
      return 1;
    } else if (target == 3) {
      return 2;
    } else if (target == 4) {
      return 2 * 2;
    }
    int x = target / 3;
    int y = target % 3;
    if (y == 0) {
      return (int) Math.pow(3, x);
    } else if (y == 1) {
      return (int) (2 * 2 * Math.pow(3, x - 1));
    } else {
      return (int) (Math.pow(3, x) * 2);
    }
  }

  public static void main(String[] args) {
    int i = new CutRope().cutRope2(7);
    System.out.println(i);

    int a = -8;
    System.out.println(a);
    System.out.println(Integer.toBinaryString(a));
    a >>= 3;
    System.out.println(a);
    System.out.println(Integer.toBinaryString(a));
  }


}
