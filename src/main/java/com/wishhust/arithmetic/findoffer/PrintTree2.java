package com.wishhust.arithmetic.findoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

public class PrintTree2 {
  public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    if (null == pRoot) {
      return new ArrayList<>();
    }
    ArrayList<ArrayList<Integer>> retList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(pRoot);
    boolean isFinish = true;
    int size = 0;
    while (!queue.isEmpty()) {
      if (isFinish) {
        size = queue.size();
        isFinish = false;
      }
      TreeNode poll = queue.poll();
      size--;

      list.add(poll.val);

      if (size == 0) {
        retList.add(new ArrayList<>(list));
        list.clear();
        isFinish = true;
      }
      if (poll.left != null) {
        queue.add(poll.left);
      }
      if (poll.right != null) {
        queue.add(poll.right);
      }
    }
    return retList;
  }
}
