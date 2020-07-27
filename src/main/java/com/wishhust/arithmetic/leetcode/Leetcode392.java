package com.wishhust.arithmetic.leetcode;

public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        int indexS = 0;
        int indexT = 0;
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
               indexS++;
            }
            indexT++;

        }

        if (indexT == t.length() && indexS != s.length()) {
            return false;
        }
        return true;
    }
}
