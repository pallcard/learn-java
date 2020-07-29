package com.wishhust.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 恢复二叉搜索树，二叉搜索树有两个节点被交换了，通过找到这个两个节点来恢复二叉树
 *
 * 二叉搜索树特点：中序遍历的结果是有序的
 *
 * 通过对树进行中序遍历，
 *    3
 *   / \
 * 1    4
 *     /
 *    2
 * 中序遍历： 1 2 4 3
 * 3 4节点需要交换
 *
 * 将中序遍历对结果存放到数组中，然后找到逆序的节点
 * 优化：直接在中序遍历的过程中找逆序的节点
 *
 */

public class Leetcode99 {


    public void recoverTree(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        // 中序遍历放到list中
        inorderTree(root, list);

        // 待交换的两个节点
        TreeNode leftS = null;
        TreeNode rightS = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val && leftS == null) {
                leftS = list.get(i);
                rightS = list.get(i + 1);
            }
            if (leftS != null && list.get(i).val > list.get(i + 1).val) {
                rightS = list.get(i + 1);
            }
        }

        int temp = leftS.val;
        leftS.val = rightS.val;
        rightS.val = temp;
    }

    public void inorderTree(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inorderTree(root.left, list);

        list.add(root);

        inorderTree(root.right, list);
    }

    // **************优化****************//

    TreeNode pre = null;     // 当前节点的前一个节点
    TreeNode swap1 = null;   // 待交换的节点1
    TreeNode swap2 = null;   // 待交换的节点2

    public void recoverTree2(TreeNode root) {
        inorderTree2(root);
        int temp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = temp;
    }

    public void inorderTree2(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTree2(root.left);

        if (pre != null && pre.val > root.val) {
            if (swap1 == null) {
                swap1 = pre;
            }
            swap2 = root;
        }
        pre = root;
        inorderTree2(root.right);
    }


    public static void main(String[] args) {
        TreeNode treeNode = Base.array2tree(new String[]{"1", "3", null, null, "2"});
        new Leetcode99().recoverTree2(treeNode);
        System.out.println(treeNode);
    }

}
