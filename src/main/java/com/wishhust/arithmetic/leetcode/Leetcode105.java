package com.wishhust.arithmetic.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Leetcode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();


        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }

        return buildTree(preorderList, inorderList);

    }

    public TreeNode buildTree(List<Integer> preorderList, List<Integer> inorderList) {
        if (preorderList.isEmpty()) {
            return null;
        }
        if (preorderList.size() == 1) {
            return new TreeNode(preorderList.get(0));
        }
        // 先序遍历第一个节点为root
        int rootV = preorderList.get(0);
        int indexRoot = inorderList.indexOf(rootV);
        TreeNode root = new TreeNode(rootV);
        List<Integer> inorderLeft = inorderList.subList(0, indexRoot);
        List<Integer> inorderRight = inorderList.subList(indexRoot+1, inorderList.size());

        List<Integer> preorderLeft = preorderList.subList(1, 1+inorderLeft.size());
        List<Integer> preorderRight = preorderList.subList(1+inorderLeft.size(), preorderList.size());

        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = new Leetcode105().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

}
