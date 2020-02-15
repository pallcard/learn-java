package com.wishhust.findoffer;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
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
}
