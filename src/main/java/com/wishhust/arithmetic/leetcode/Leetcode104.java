package com.wishhust.arithmetic.leetcode;

/**
 * 二叉树最大深度
 */

public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right)+1;
    }


}
