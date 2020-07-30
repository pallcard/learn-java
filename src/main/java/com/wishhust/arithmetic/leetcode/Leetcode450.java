package com.wishhust.arithmetic.leetcode;


/**
 * 删除二叉搜索树中的节点
 *
 * 二叉搜索树特点，左子树节点值 < 根 < 右子树节点值
 *
 * key > root.val  ===> 去右子树删
 * key < root.val  ===> 去左子树删
 * key = root.val  ===> 删除root
 *     1. root无左/右边子树 ===> 用 右/左子树替代 root
 *     2. root有左右子树    ===> 用 右子树中最小节点minNode替换根（用minNode值替换root，然后在右子树中删除minNode）
 */
public class Leetcode450 {

    // 在root树中删除key，返回删除之后的root树
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
            // 左右孩子都不空, 找右子树的最小节点去替换root
            TreeNode min = root.right;
            while (min.left != null) {
                min = min.left;
            }
            // 替换root的值
            root.val = min.val;
            // 已经是用min替换了root，需要删除右子树中 min节点
            root.right = deleteNode(root.right, min.val);
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
