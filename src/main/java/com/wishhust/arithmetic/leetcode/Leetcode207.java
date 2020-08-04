package com.wishhust.arithmetic.leetcode;

import com.wishhust.base.HashMapTest;

import java.util.*;

public class Leetcode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, Integer> countMap = new HashMap();

        for (int i = 0; i < prerequisites.length; i++) {
            countMap.put(prerequisites[i][0], countMap.getOrDefault(prerequisites[i][0], 0)+1);
            countMap.put(prerequisites[i][1], countMap.getOrDefault(prerequisites[i][1], 0));

        }

        while (!countMap.keySet().isEmpty()) {
            boolean flag = false;
            HashSet<Integer> keys = new HashSet<>();
            for (Integer key : countMap.keySet()) {
                if (countMap.get(key) == 0) {
                    flag = true;
                    numCourses--;
                    if (numCourses == 0) {
                        return true;
                    }
                    keys.add(key);
                    for (int i = 0; i < prerequisites.length; i++) {
                        if (prerequisites[i][1] == key) {
                            countMap.put(prerequisites[i][0], countMap.getOrDefault(prerequisites[i][0], 1)-1);
                        }
                    }
                }
            }
            for (Integer key : keys) {
                countMap.remove(key);
            }
            keys.clear();

            if (!flag && numCourses > 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Leetcode207().canFinish(2, new int[][]{{1, 0}}));
    }
}

