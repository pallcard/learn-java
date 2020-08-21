package com.wishhust.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int valid = 0;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) +1);
        }

        while (right < s.length()) {

            char addCh = s.charAt(right++);
            if (need.containsKey(addCh)) {
                window.put(addCh, window.getOrDefault(addCh, 0) +1);
                if (window.get(addCh) <= need.get(addCh)) {
                    valid++;
                }
            }

            while (right-left >= p.length()) {
                if (valid == p.length()) {
                    res.add(left);
                }
                char delCh = s.charAt(left++);
                if (need.containsKey(delCh)) {
                    if(window.get(delCh)<= need.get(delCh)) {
                        valid--;
                    }
                    window.put(delCh, window.getOrDefault(delCh, 1)-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = new Leetcode438().findAnagrams("baa", "aa");
        System.out.println(anagrams);
    }
}
