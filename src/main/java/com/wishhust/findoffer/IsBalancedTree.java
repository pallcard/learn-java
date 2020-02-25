package com.wishhust.findoffer;

public class IsBalancedTree {
  public boolean IsBalanced_Solution(TreeNode root) {
    if (null == root) {
      return true;
    }
    int left = TreeDepth(root.left);
    int right = TreeDepth(root.right);
    if (Math.abs(left-right)>1) {
      return false;
    }
    return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
  }

  public int TreeDepth(TreeNode root) {
    if (null == root) {
      return 0;
    }
    return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
  }


  public boolean IsBalanced_Solution2(TreeNode root) {
    return getTreeDeep(root) != -1;
  }

  private int getTreeDeep(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = getTreeDeep(root.left);
    if (left == -1) {
      return -1;
    }
    int right = getTreeDeep(root.right);
    if (right == -1) {
      return -1;
    }
    return Math.abs(left-right)>1 ? -1 : Math.max(left,right)+1;
  }
}
