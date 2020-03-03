package com.wishhust.arithmetic.findoffer;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * 方法一：
 * 计算左子树的节点个数
 *  1. leftCount = k-1 则根即为所求
 *  2. leftCount < k-1 则递归在右子树找   k-leftCount-1
 *  3. leftCount > k-1 则递归在左子树找， k
 *
 * 方法二：
 * 使用中序遍历为一个递增的序列的特性
 */
public class KthNodeInTree {
  TreeNode KthNode(TreeNode pRoot, int k) {
    int count = findTreeCount(pRoot);
    if (k == 0 || count < k) {
      return null;
    }
    int leftCount = findTreeCount(pRoot.left);
    if (leftCount == k-1) {
      return pRoot;
    } else if(leftCount < k-1) {
      return KthNode(pRoot.right, k - leftCount-1);
    } else {
      return KthNode(pRoot.left, k);
    }
  }

  private int findTreeCount(TreeNode root) {
    int count = 0;
    if (null == root) {
      return count;
    }
    count++;
    count += findTreeCount(root.left);
    count += findTreeCount(root.right);
    return count;
  }

  TreeNode KthNode2(TreeNode pRoot, int k) {
    if (pRoot == null) {
      return null;
    }
    kth = k;
    return findKthNode(pRoot);
  }

  private int kth;
  TreeNode findKthNode(TreeNode pRoot) {
    TreeNode target = null;
    if (pRoot.left != null) {
      target = findKthNode(pRoot.left);
    }
    if (null == target) {
      if (kth == 1) {
        target = pRoot;
      }
      kth--;
    }

    if (target == null && pRoot.right != null) {
      target = findKthNode(pRoot.right);
    }
    return target;
  }

}
