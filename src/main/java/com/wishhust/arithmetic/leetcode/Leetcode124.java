package com.wishhust.arithmetic.leetcode;


/**
 * 二叉树中的最大路径和
 *
 * 采用后序遍历的方式，在遍历过程中找到最大子路径和，
 *
 */

public class Leetcode124 {

    public static int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;
    }

    // 以root为根的树的路径最大值
    public int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));

        max = Math.max(max, left+right+root.val);
        return Math.max(left,right)+root.val;

    }

    public static void main(String[] args) {
        TreeNode treeNode = Base.array2tree(new String[]{"-10", "9", "20", null, null, "15", "20"});

        int i = new Leetcode124().maxPathSum(treeNode);
        System.out.println(i);
    }

    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);

        int result = 0;
        if (root.val >= 0) {
            result += root.val;
            if(left>0) {
                result+=left;
            }
            if (right>0) {
                result += right;
            }
        } else {
            if (left>0 && right>0 && (left+root.val>0) && (right+root.val)>0) {
                result += (left+right+root.val);
            } else {
                result += Math.max(Math.max(left, right), root.val);
            }
        }
        return result;
    }
}
