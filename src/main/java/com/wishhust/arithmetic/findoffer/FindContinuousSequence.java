package com.wishhust.arithmetic.findoffer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 用两个值分别记录当前list的开始start和结束end
 * 当前序列和小于sum时，end++
 *          大于       start++
 */
public class FindContinuousSequence {
  public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    int start = 1;
    int end = 2;
    list.add(start);
    list.add(end);
    int curSum = start + end;
    do {
      if (curSum == sum) {
        ret.add(new ArrayList<>(list));
      }

      if (curSum <= sum) {
        end++;
        curSum += end;
        list.add(end);
      } else {
        curSum -= start;
        list.remove(Integer.valueOf(start++));
      }
    } while (start <= sum/2);
    return ret;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> arrayLists = new FindContinuousSequence()
        .FindContinuousSequence(9);
    System.out.println(arrayLists);
  }
}
