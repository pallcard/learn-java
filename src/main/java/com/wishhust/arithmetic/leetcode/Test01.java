package com.wishhust.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test01 {

    public int getCountArray(int [] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = arr[0];
        map.put(sum, 1);
        int result = 0;
        map.put(0, 1);
        if (map.containsKey(k)) {
            result += map.get(k);
        }
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum)+1);
            } else {
                map.put(sum, 1);
            }

            if(map.containsKey(sum-k)) {
                result += map.get(sum-k);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Test01().getCountArray(new int[]{1,-1,1,1}, 2));
    }
}
