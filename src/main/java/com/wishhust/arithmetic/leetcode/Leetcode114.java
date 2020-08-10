package com.wishhust.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 方案一：直接使用二叉树到先序遍历，将节点存放到一个集合中，然后在加集合中到元素连接成一个链表
 *  此方案无法满足原地
 *
 * 方案二：先序遍历特点（根 左 右），
 * 若当前节点cur无左子树，则cur的下一个节点就是其右子树
 * 若当前节点cur有左子树，则cur的下一个节点为其左子树next，而其右节点的前一个节点pre为next的最右节点
 *
 * 实现：需要定义三个节点指针，
 * cur：指向当前节点
 * next：指向当前节点的下一个节点
 * pre：指向当前节点的右子树的前一个节点
 */

public class Leetcode114 {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }

    }

    public void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);

        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
                continue;
            }
            // 保存下一个节点
            TreeNode next = cur.left;
            TreeNode pre = next;
            while (pre.right != null) {
                pre = pre.right;
            }
            pre.right = cur.right;
            cur.right = next;
            cur.left = null;
            cur = next;
        }
    }


    public void flatten2(TreeNode root) {

        preOrder2(root, null);

    }
    public void preOrder2(TreeNode root, TreeNode last) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            last = root;
        }

        if (root.right == null) {
            root.right = root.left;
        }

        TreeNode leftLast = null;
        TreeNode rightLast = null;

        if (root.left != null) {
            preOrder2(root.left, leftLast);

        }

        if (root.right != null) {
            preOrder2(root.right, rightLast);
        }

    }

}
