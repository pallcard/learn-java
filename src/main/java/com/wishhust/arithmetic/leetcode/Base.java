package com.wishhust.arithmetic.leetcode;

import java.util.*;

public class Base {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();

        // output
        System.out.println();

        int[] ints = new int[] {1,2,3};


        List list = new ArrayList<Integer>();

        // 队列
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.peek();
        queue.poll();

        // 优先队列
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.poll();

        // 栈
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}