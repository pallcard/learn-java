package com.wishhust.arithmetic.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode3 {
    public static void main(String[] args) {
        int res = new Leetcode3().lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);
    }

//  abcabcbb
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        Queue<Character> window = new LinkedList<>();
        int right = 0;
        int max = 1;

        while (right < s.length()) {
            char addCh = s.charAt(right);
            if (window.contains(addCh)) {
                max = Math.max(max, window.size());
                while (window.peek() != addCh) {
                    window.poll();
                }
                window.poll();
            }
            window.add(addCh);
            right++;
        }

        return Math.max(max, window.size());
    }

}
