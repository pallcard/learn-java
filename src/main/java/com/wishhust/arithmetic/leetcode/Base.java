package com.wishhust.arithmetic.leetcode;

import apple.laf.JRSUIUtils;

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

        System.out.println("-------------");

        TreeNode treeNode = array2tree(new String[]{"-10", "9", "20", null, null, "15", "20"});
        System.out.println();

    }

//    [-10,9,20,null,null,15,7]
    public static TreeNode array2tree(String[] array){
        int index = 0;

        TreeNode root = new TreeNode(Integer.parseInt(array[index++]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (index < array.length && !queue.isEmpty()) {
            TreeNode rootTemp = queue.poll();
            TreeNode left = null;
            if (array[index] != null) {
                left = new TreeNode(Integer.parseInt(array[index++]));
                queue.add(left);
            } else {
                index++;
            }
            rootTemp.left = left;
            if (index == array.length) {
                break;
            }

            TreeNode right = null;
            if (array[index] != null) {
                right = new TreeNode(Integer.parseInt(array[index++]));
                queue.add(right);
            } else {
                index++;
            }
            rootTemp.right = right;
        }

        return root;
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

class Node {
    int key, value;
    Node pre, next;
    public Node(int k, int v) {
        this.key = k;
        this.value = v;
    }
}

class DoubleList {
    Node head, tail;
    int size;

    public DoubleList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    // 尾插入
    public void addLast(Node node) {
        node.pre = tail.pre;
        node.next = tail;
        node.pre.next = node;
        tail.pre = node;
        size++;
    }

    // 删除指定节点
    public void delNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    // 删除首节点
    public Node delFirst() {
        // 没有节点
        if (head.next == tail) {
            return null;
        }
        Node node = head.next;
        head.next = head.next.next;
        head.next.pre = head;
        size--;
        return node;
    }
}