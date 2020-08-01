package com.wishhust.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为k的子数组
 * index    0  1   2   3
 *      [   1  -1  1   1  ]  k=2
 * sum      1  0   1   2
 *
 * sum为累加和，(i, j)的和为sum(j) - sum(i)
 * 在计算sum时，统计当前sum出现的次数，初始需要put（0，1） 到map中
 * 当index = 3时，此时sum=2，找sum-k=0出现的次数，此时map.get(0) = 2
 * 对2进行解释：
 *      当index = 3时，累加和为2，要找的k=2，需要找前面累加和为0出现的次数
 *      初始(假设下标-1)出现1次  ===> 子数组是【0，3】
 *      index=1时出现1次       ===> 子数组是【2，3】
 *
 */
public class Leetcode560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap();
        countMap.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 累加和
            sum += nums[i];
            count += countMap.getOrDefault(sum-k, 0);
            // 插入sum到map中
            if (countMap.containsKey(sum)) {
                countMap.put(sum, countMap.get(sum)+1);
            } else {
                countMap.put(sum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode560().subarraySum(new int[]{1,2,3}, 3));
    }
}
