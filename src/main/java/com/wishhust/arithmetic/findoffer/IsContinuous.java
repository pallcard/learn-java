package com.wishhust.arithmetic.findoffer;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2-10数字本身，A为1，J为11，Q为12，K为13，大小王可以看出任意的数字。
 *
 * 统计0的个数 a，
 * 统计数组中间隔的个数 b。
 * 当d >= b时，返回true，否则返回false
 */
public class IsContinuous {
  public boolean isContinuous(int [] numbers) {
    if (numbers.length == 0) {
      return false;
    }

    boolean [] continuous = new boolean[14];
    int minNum = 14;
    int countOf0 = 0;
    for (int i = 0; i < numbers.length; i++) {
      continuous[numbers[i]] = true;
      if (numbers[i] == 0) {
        countOf0++;
        continue;
      }
      if (numbers[i] < minNum) {
        minNum = numbers[i];
      }
    }
    for (int i = 0; i < numbers.length; i++) {
      if (!continuous[minNum+i] && countOf0-- <= 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    boolean continuous = new IsContinuous().isContinuous(new int[]{0,3,2,6,4});
    System.out.println(continuous);
  }
}
