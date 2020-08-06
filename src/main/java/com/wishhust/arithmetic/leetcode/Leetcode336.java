package com.wishhust.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                List<Integer> ints = new ArrayList<>();
                if (isHUiWen(words[i]+words[j])) {
                   ints.add(i);
                   ints.add(j);
                   list.add(ints);
                }
            }
        }
        return list;
    }

    public boolean isHUiWen(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        ["abcd","dcba","lls","s","sssll"]
        String [] str = new String[] {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> lists = new Leetcode336().palindromePairs(str);
        System.out.println(lists);
    }
}
