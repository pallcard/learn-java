package com.wishhust.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIpAddresses(s,res, new StringBuilder(), 0);
        return res;
    }
    // 12345      0
    // 1.2345     1
    // 1.2.345    2
    // 1.2.3.45   3
    // 1.2.3.45.  4
    public void restoreIpAddresses(String s, List<String> res, StringBuilder temp,  int step) {
        if (step == 4 && s.length()==0) {
            res.add(temp.substring(0, temp.length()-1));
            return;
        } else if (step == 4 || s.length()==0) {
           return;
        }

        // 1, 12, 123
        for (int i = 0; i < s.length() && i <= 2; i++) {
            String substring = s.substring(0, i + 1);
            if (Integer.parseInt(substring) < 0 || Integer.parseInt(substring) > 255 || (substring.charAt(0) == '0' && substring.length() > 1)) {
                continue;
            }
            temp.append(s, 0, i+1);
            temp.append(".");
            restoreIpAddresses(s.substring(i+1), res, temp, step+1);
            temp.deleteCharAt(temp.length()-1);
            temp.delete(temp.lastIndexOf(".")+1, temp.length());
        }

    }

    public static void main(String[] args) {
        List<String> strings = new Leetcode93().restoreIpAddresses("00000");
        System.out.println(strings);
    }
}
