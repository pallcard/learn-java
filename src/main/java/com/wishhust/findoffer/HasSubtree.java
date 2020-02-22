package com.wishhust.findoffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
  public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    if (root1 == null || root2 == null) {
      return false;
    }
    boolean rootEqual = false;
    if (root1.val == root2.val) {
      rootEqual =  isEqualStruct(root1, root2);
    }
    return rootEqual || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
  }

  private boolean isEqualStruct(TreeNode root1, TreeNode root2) {
    if (root2 == null) {
      return true;
    }
    if (root1 == null) {
      return false;
    }
    if (root1.val == root2.val) {
      return isEqualStruct(root1.left, root2.left) && isEqualStruct(root1.right, root2.right);
    }
    return false;
  }

}
