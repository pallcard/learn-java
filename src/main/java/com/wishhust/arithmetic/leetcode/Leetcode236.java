package com.wishhust.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> node_p_path = new ArrayList<>(); // 存储p节点的路径
        List<TreeNode> node_q_path = new ArrayList<>(); // 存储q节点的路径


        preorder(root, p, node_p_path);

        isFinish = false;
        preorder(root, q, node_q_path);

        int path_len = 0; // 较短路径的长度

        if (node_p_path.size() < node_q_path.size()) {
            path_len = node_p_path.size();
        } else {
            path_len = node_q_path.size();
        }

        TreeNode result = null;
        for (int i = 0; i < path_len; i++) {
            if (node_p_path.get(i) == node_q_path.get(i)) {
                result = node_p_path.get(i);
            }
        }
        return result;
    }

    public Boolean isFinish = false;

    // 求根节点至某节点的路径
    public void preorder(TreeNode node, TreeNode search, List<TreeNode> result) {
        if (node == null || isFinish) {
            return;
        }
        result.add(node); // 先序遍历，将节点压入栈

        if (node == search) {
            isFinish = true;  // 当找到search节点后，标记finish变量
            return;
        }

        preorder(node.left, search, result);
        if (isFinish) {
            return;
        }
        if (node.left != null) {
            result.remove(result.size() - 1);
        }


        preorder(node.right, search, result);
        if (isFinish) {
            return;
        }
        if (node.right != null) {
            result.remove(result.size() - 1);
        }

    }

    public static void main(String[] args) {
        /**
         *        3
         *     5    1
         *  6   2  0   8
         *     7 4
         *
         */
    }
}
