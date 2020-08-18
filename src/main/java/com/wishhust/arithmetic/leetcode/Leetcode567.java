package com.wishhust.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串排列
 */
public class Leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int valid = 0;


        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0)+1);
        }

        while (right < s2.length()) {

            char addCh = s2.charAt(right);
            right++;
            if (need.containsKey(addCh)) {
                window.put(addCh, window.getOrDefault(addCh, 0)+1);
                if (need.get(addCh) >= window.get(addCh)) {
                    valid++;
                }
            }


            while (valid == s1.length()) {

                if (right-left == s1.length()) {
                    return true;
                }

                char delCh = s2.charAt(left);
                left++;
                if (need.containsKey(delCh)) {
                    if (need.get(delCh) >= window.get(delCh)) {
                        valid--;
                    }
                    window.put(delCh, window.getOrDefault(delCh, 1)-1);

                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean b = new Leetcode567().checkInclusion("adc","dcda");
        System.out.println(b);
    }
}
