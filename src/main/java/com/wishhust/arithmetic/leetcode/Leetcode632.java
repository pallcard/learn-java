package com.wishhust.arithmetic.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode632 {

    public int[] smallestRange(List<List<Integer>> nums) {
//        List<Integer> numList = nums.stream().flatMap(List::stream).collect(Collectors.toList());


        List<Integer> numList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                map.put(nums.get(i).get(j), i);
                numList.add(nums.get(i).get(j));
            }
        }
        numList.sort(Comparator.comparingInt(value -> value));

        int min = Integer.MAX_VALUE;
        int currentCount = 0;

        int left = 0;
        int right = 0;
        Set<Integer> indexList = new HashSet<>();
        while (right < numList.size()) {
            for (int i = 0; i < numList.size(); i++) {
                if (numList.get(left) <= numList.get(i) && numList.get(right) >= numList.get(i)) {
                    indexList.add(map.get(numList.get(i)));
                }

                if (indexList.size() >= nums.size()) {
                    min = Math.min(min, right-left+1);
                } else {
                    right++;
                }
            }


        }

        System.out.println(numList);
        return new int[]{};
    }


    public int[] smallestRange2(List<List<Integer>> nums) {
        PriorityQueue<Node632> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(it-> it.val));

        int max = -1;
        int start = 0;
        int end = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            priorityQueue.offer(new Node632(i, 0, val));
            max = Math.max(max, val);
        }

        while (priorityQueue.size() == nums.size()) {
            Node632 node = priorityQueue.poll();
            int i = node.i;
            int j = node.j;
            int val = node.val;

            if (max - val < end - start) {
                start = val;
                end = max;
            }

            if (j+1<nums.get(i).size()) {
                int nval = nums.get(i).get(j+1);
                priorityQueue.offer(new Node632(i, j+1, nval));
                max = Math.max(max, nval);
            }
        }

        return new int[]{start, end};
    }



    public static void main(String[] args) {
        List<List<Integer>> integers = new ArrayList<>();
        List<Integer> integer1 = new ArrayList<>();
        List<Integer> integer2 = new ArrayList<>();
        integer1.add(1);
        integer1.add(2);
        integer1.add(3);
        integer2.add(4);
        integers.add(integer1);
        integers.add(integer2);
        new Leetcode632().smallestRange(integers);
    }
}

class Node632 {
    int i;      // 第i个数组
    int j;      // 第i个数组中第j个元素
    int val;    // 元素值
    public Node632(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}
