package com.wishhust.arithmetic.findoffer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 深度优先遍历
 */

public class FindPathInTree {
  private ArrayList<Integer> tempList = new ArrayList<>();
  private ArrayList<ArrayList<Integer>> retList = new ArrayList<>();
  public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    if (root == null) {
      return retList;
    }
    if (root.left == null && root.right == null && target == root.val) {
      tempList.add(root.val);
      retList.add(new ArrayList<>(tempList));
      tempList.remove(tempList.size()-1);
      return retList;
    }
    if (root != null) {
      tempList.add(root.val);
      FindPath(root.left, target-root.val);
      FindPath(root.right, target-root.val);
      tempList.remove(tempList.size()-1);
    }
    return retList;
  }
}
