package com.wishhust.arithmetic.leetcode;

/**
 * Created by liuke on 2019/12/18 19:57
 *
 * <p>只出现一次的数字
 *
 * <p>给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * <p>说明：
 *
 * <p>你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * <p>输入: [2,2,1] 输出: 1
 */
public class SingleNumber {

  // 数组中只出现一次的数字只有一个
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result ^= nums[i];
    }
    return result;
  }

  // 数组中出现一次的数字有两个
  public int[] singleNumber2(int[] nums) {
    int[] result = new int[2];
    int temp = 0;
    for (int i = 0; i < nums.length; i++) {
      temp ^= nums[i];
    }
    String tempBin = Integer.toBinaryString(temp);
    int index = tempBin.length() - tempBin.lastIndexOf('1');
    for (int i = 0; i < nums.length; i++) {
      String str = Integer.toBinaryString(nums[i]);
      if (str.charAt(str.length() - index) == '1') {
        result[0] ^= nums[i];
      } else {
        result[1] ^= nums[i];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    //
    int[] ints = new SingleNumber().singleNumber2(new int[] {1, 2, 3, 3, 2, 4});
    System.out.println(ints.toString());
  }
}
