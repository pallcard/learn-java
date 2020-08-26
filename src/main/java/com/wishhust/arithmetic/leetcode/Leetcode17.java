package com.wishhust.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode17 {

    private char[][] direct = new char[][]{
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'},
    };


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() <= 0) {
            return list;
        }
        dfs(digits, new StringBuilder());
        return list;
    }

    private List<String> list = new ArrayList<>();

    public void dfs(String digits, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            sb = new StringBuilder();
            return;
        }

        int index = digits.charAt(sb.length())-'0'-2;

        for (int i = 0; i < direct[index].length; i++) {
            sb.append(direct[index][i]);
            dfs(digits, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Leetcode17().letterCombinations("23");
        System.out.println(strings);
    }

}
