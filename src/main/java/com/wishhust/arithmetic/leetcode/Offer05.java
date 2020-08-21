package com.wishhust.arithmetic.leetcode;

public class Offer05 {

    //We%20are%20happy
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
