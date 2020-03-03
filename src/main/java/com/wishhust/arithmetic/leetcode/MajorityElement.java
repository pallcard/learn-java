package com.wishhust.arithmetic.leetcode;

/**
 * Created by liuke on 2019/12/18 20:23
 *
 * <p>多数元素
 *
 * <p>给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * <p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * <p>输入: [2,2,1,1,1,2,2] 输出: 2
 */
public class MajorityElement {

  public int majorityElement(int[] nums) {
    int count = 1; // 元素出现次数
    int temp = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (count == 0) {
        temp = nums[i];
        count++;
      } else if (nums[i] == temp) {
        count++;
      } else {
        count--;
      }
    }
    return temp;
  }

  public static void main(String[] args) {
    //
    new MajorityElement().majorityElement(new int[] {10, 9, 9, 9, 10});
  }
}
