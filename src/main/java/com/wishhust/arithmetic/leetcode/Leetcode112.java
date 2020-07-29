package com.wishhust.arithmetic.leetcode;

/**
 * 路径总和,根到叶子节点组成到路径和为sum
 *
 * 后序遍历
 */

public class Leetcode112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }


    public static void main(String[] args) {

        TreeNode treeNode = Base.array2tree(new String[]{"5", "4", "8", "11", null, "13", "4", "7", "2", null, null, null, "1"});
        System.out.println(new Leetcode112().hasPathSum(treeNode, 22));
    }
}
