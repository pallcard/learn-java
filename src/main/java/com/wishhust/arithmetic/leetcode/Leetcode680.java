package com.wishhust.arithmetic.leetcode;

public class Leetcode680 {

    public static void main(String[] args) {
        System.out.println(new Leetcode680().validPalindrome("abdca"));
    }
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s.substring(left,right)) || isPalindrome(s.substring(left+1,right+1));
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
