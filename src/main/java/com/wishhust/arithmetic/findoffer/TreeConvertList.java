package com.wishhust.arithmetic.findoffer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class TreeConvertList {
  // 记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节点
  private TreeNode lastLeft = null;
  public TreeNode Convert(TreeNode pRootOfTree) {
    if (pRootOfTree == null) {
      return null;
    }
    if (pRootOfTree.left == null && pRootOfTree.right == null) {
      lastLeft = pRootOfTree;
      return pRootOfTree;
    }
    // 1.将左子树构造成双链表，并返回链表头节点
    TreeNode left = Convert(pRootOfTree.left);
    // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
    if (left != null) {
      lastLeft.right = pRootOfTree;
      pRootOfTree.left = lastLeft;
    }
    // 当根节点只含左子树时，则该根节点为最后一个节点
    lastLeft = pRootOfTree;
    // 4.将右子树构造成双链表，并返回链表头节点
    TreeNode right = Convert(pRootOfTree.right);
    // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
    if (right != null) {
      pRootOfTree.right = right;
      right.left = pRootOfTree;
    }
    return left != null ? left : pRootOfTree;
  }
}
