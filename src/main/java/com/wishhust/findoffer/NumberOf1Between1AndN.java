package com.wishhust.findoffer;

/**
 *求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 *
 */
public class NumberOf1Between1AndN {

  public int NumberOf1Between1AndN_Solution(int n) {
    int count = 0;
    for (int i =1; i<=n; i++) {
      count += countOf1(i);
    }
    return count;
  }

  private int countOf1(int n) {
    int count = 0;
    while (n != 0) {
      if (n % 10 ==1) {
        count++;
      }
      n /= 10;
    }
    return count;
  }

  public int NumberOf1Between1AndN_Solution2(int n) {
    return numberOf1Between1AndN_Solution("" + n);
  }

  public int numberOf1Between1AndN_Solution(String num) { //21345
    int first = num.charAt(0)-'0';
    int length = num.length();
    if (length == 1 && first >= 1) {
      return 1;
    }
    if (length == 1 && first == 0) {
      return 0;
    }
    // 最高位中1的个数    1346-21345中万位1个数
    int highNumOf1 = 0;
    if (first > 1) {
      highNumOf1 = (int) Math.pow(10, length-1);
    } else {
      highNumOf1 = Integer.parseInt(num.substring(1))+1;
    }

    // 其余位出现1   1346-11345，11345-21345 10^3*2*4
    int otherNumOf1 = (int) Math.pow(10, length-2) * (length-1)* first;

    //  1-1345
    int other = numberOf1Between1AndN_Solution(num.substring(1));
    return highNumOf1+otherNumOf1+other;
  }

  public static void main(String[] args) {
    int i = new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(21345);
    int i2 = new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution2(21345);
    System.out.println(i);
    System.out.println(i2);
  }

}
