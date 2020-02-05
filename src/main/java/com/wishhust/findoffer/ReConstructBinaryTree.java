package com.wishhust.findoffer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class ReConstructBinaryTree {

  public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    return buildTree(pre, 0, pre.length, in, 0, in.length);
  }

  private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart,
      int inEnd) {
    if (preEnd - preStart < 1) {
      return null;
    }
    if (preEnd - preStart == 1) {
      return new TreeNode(pre[preStart]);
    }
    TreeNode root = new TreeNode(pre[preStart]);
    int indexRoot = findIndex(in, inStart, inEnd, root.val);

    int leftChildCount = indexRoot - inStart;
    // 左
    root.left = buildTree(pre, preStart+1, preStart+1 + leftChildCount, in, inStart, indexRoot);
    // 右
    root.right = buildTree(pre, preStart+1 + leftChildCount, preEnd, in, indexRoot+1, inEnd);
    return root;
  }

  private int findIndex(int[] array, int start, int end, int target) {
    for (int i = start; i < end; i++) {
      if (array[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {

    int[] pre = new int[] {1,2,4,7,3,5,6,8};
    int[] in = new int[] {4,7,2,1,5,3,8,6};

    TreeNode treeNode = new ReConstructBinaryTree().reConstructBinaryTree(pre, in);
    System.out.println(treeNode);
  }
}
