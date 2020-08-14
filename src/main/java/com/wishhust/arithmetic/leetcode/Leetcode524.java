package com.wishhust.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 *
 * "abpcplea"
 * ["a","b","c"]
 */
public class Leetcode524 {

    public static void main(String[] args) {
        List<String> d = new ArrayList<>();
        d.add("a");
        d.add("b");
        d.add("c");
        System.out.println(new Leetcode524().findLongestWord("abpcplea", d));

    }

    public String findLongestWord(String s, List<String> d) {
        String maxString = "";
        for (int i = 0; i < d.size(); i++) {
            String dir = d.get(i);
            if (isMatch(s, dir) && (dir.length() > maxString.length() || (dir.length() == maxString.length() && dir.compareTo(maxString)<0))) {
                maxString = dir;
            }
        }
        return maxString;
    }

    public boolean isMatch(String origin, String str) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < origin.length() && p2 < str.length()) {
            if(origin.charAt(p1) == str.charAt(p2)) {
                p1++;
                p2++;
            } else {
                p1++;
            }
        }
        if (p2 == str.length()) {
            return true;
        } else {
            return false;
        }
    }
}
