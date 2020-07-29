package com.wishhust.arithmetic.leetcode;


/**
 * 删除二叉搜索树中的节点
 *
 */
public class Leetcode450 {


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 左右孩子都不空
            TreeNode min = root.right;
            while (min.left != null) {
                min = min.left;
            }
            root.val = min.val;
            root.right = deleteNode(min, min.val);
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Base.array2tree(new String[]{
                "5", "3", "6", "2" , "4", null, "7"
        });
        TreeNode newNode = new Leetcode450().deleteNode(treeNode, 3);
        System.out.println(newNode);
    }

}
