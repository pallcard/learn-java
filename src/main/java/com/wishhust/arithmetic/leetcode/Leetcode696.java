package com.wishhust.arithmetic.leetcode;

/**
 *
 * 计数二进制子串
 *
 * 输入: "00110011"
 * 输出: 6
 *
 * 统计相邻的相同的个数
 *   2 2 2 2
 *   说明： 先是两个0， 然后两个1，两个0，然后1
 *  然后计算相邻的取个数较小的数
 *
 */

public class Leetcode696 {

    public int countBinarySubstrings2(String s) {
        if (s.length()<2) {
            return 0;
        }

        int index = 0;
        int [] count = new int[s.length()];
        int curLength = 1;

        int res = 0;

        char ch = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (ch != s.charAt(i)) {
                count[index++] = curLength;
                ch = s.charAt(i);
                curLength = 1;
            } else {
                curLength++;
            }
        }
        count[index++] = curLength;

        for (int i = 0; i < index-1; i++) {
            res += Math.min(count[i],count[i+1]);
        }

        return res;
    }

    public int countBinarySubstrings(String s) {
        if (s.length()<2) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j+=2) {
               if (isNeed2(s.substring(i, j+1))) {
                   count++;
               }
            }
        }
        return count;
    }

    private boolean isNeed2(String s) {
        char c = s.charAt(0);
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) == s.charAt(s.length()-i-1)) {
                return false;
            }
            if (c != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isNeed(int i, int j, int[] zeroSum, int[] oneSum) {
        if (zeroSum[j] - zeroSum[i] == oneSum[j] -oneSum[i]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int i = new Leetcode696().countBinarySubstrings2("00110");
        System.out.println(i);
    }

}
