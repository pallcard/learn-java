package com.wishhust.arithmetic.leetcode;

public class Leetcode459 {
    public boolean repeatedSubstringPattern(String s) {
        int strLen = s.length();
        if (strLen % 2 != 0) {
            return false;
        }

        for (int i = 0; i < strLen/2; i++) {
            if (s.charAt(i) != s.charAt(strLen/2+i)) {
                return false;
            }
        }


        return true;
    }
}
