package com.wishhust.arithmetic.findoffer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

class TreeLinkNode {
  int val;
  TreeLinkNode left = null;
  TreeLinkNode right = null;
  TreeLinkNode next = null;

  TreeLinkNode(int val) {
    this.val = val;
  }
}
public class GetNextInTree {
  public TreeLinkNode GetNext(TreeLinkNode pNode) {
    TreeLinkNode ret = null;
    if (pNode == null) {
      return ret;
    }
    // the first of left child of the right child of the node
    if (pNode.right != null) {
      ret = pNode.right;
      while (ret.left != null) {
        ret = ret.left;
      }
      return ret;
    }
    // the left child of the node parent
    while (pNode.next != null) {
      if (pNode.next.left == pNode) {
        return pNode.next;
      }
      pNode = pNode.next;
    }

    return null;
  }
}
