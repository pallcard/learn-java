package com.wishhust.arithmetic.leetcode;

public class Leetcode337 {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.right != null) {
            return Math.max(root.val+ rob(root.left.left)+rob(root.left.right)+rob(root.right.left)+rob(root.right.right), rob(root.left)+rob(root.right));
        } else if (root.left != null) {
            return Math.max(root.val+ rob(root.left.left)+rob(root.left.right), rob(root.left));
        } else if (root.right != null) {
            return Math.max(root.val+rob(root.right.left)+rob(root.right.right), rob(root.right));
        } else {
            return root.val;
        }

    }

}
