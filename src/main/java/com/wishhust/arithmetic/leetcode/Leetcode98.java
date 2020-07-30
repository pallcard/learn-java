package com.wishhust.arithmetic.leetcode;


/**
 * 验证二叉搜索树
 *
 * 通过使用参数列表记录
 *
 *    10
 *   /  \
 *  5   15
 *     /  \
 *    6    20
 *
 *               BST(10, null, null)
 *               /                 \
 *      BST(5, null, 10)     BST(15, 10, null)
 *                          /                 \
 *       不符合《=== BST(6, 10, 15)        BST(20, 15, null)
 *
 *
 *
 *    10
 *   /  \
 *  5   15
 *     /  \
 *    13  20
 *
 *               BST(10, null, null)
 *               /                 \
 *      BST(5, null, 10)     BST(15, 10, null)
 *                          /                 \
 *              BST(13, 10, 15)        BST(20, 15, null)
 *
 */
public class Leetcode98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
