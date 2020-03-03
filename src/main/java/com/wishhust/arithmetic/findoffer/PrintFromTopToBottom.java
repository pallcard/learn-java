package com.wishhust.arithmetic.findoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

public class PrintFromTopToBottom {

  public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (null == root) {
      return list;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode poll = queue.poll();
      list.add(poll.val);
      if (null != poll.left) {
        queue.add(poll.left);
      }
      if (null != poll.right) {
        queue.add(poll.right);
      }
    }
    return list;
  }
}
