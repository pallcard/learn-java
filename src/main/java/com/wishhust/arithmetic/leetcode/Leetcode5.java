package com.wishhust.arithmetic.leetcode;

public class Leetcode5 {
    public String longestPalindrome(String s) {
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = longestPalindrome(s, i, i);
            String s2 = longestPalindrome(s, i, i+1);
            maxStr = maxStr.length() > s1.length() ? maxStr : s1;
            maxStr = maxStr.length() > s2.length() ? maxStr : s2;
        }
        return maxStr;
    }

    public String longestPalindrome(String s, int i, int j) {
        while (i>=0 && j< s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i,j+1);
    }
}
