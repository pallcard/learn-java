package com.wishhust.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * 滑动窗口
 */

public class Leetcode76 {
    public String minWindow(String s, String t) {
        // 需要窗口
        Map<Character, Integer> need = new HashMap<>();
        // 实际窗口
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        // 窗口左右指针
        int left = 0;
        int right = 0;
        // 最小窗口长度
        int len = Integer.MAX_VALUE;
        // 最小窗口长度开始指针
        int start = 0;

        // 初始化需要窗口，包含目标串所有字符
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0)+1);
        }

        while (right < s.length()) {

            // 扩大窗口
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 窗口满足条件
            while (valid == need.size()) {
                // 记录窗口
                if (right-left < len) {
                    len = right-left;
                    start = left;
                }

                // 缩小窗口
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d,1)-1);
                }

            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);

    }

    public static void main(String[] args) {
        String s = new Leetcode76().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
