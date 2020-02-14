package com.wishhust.findoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 1. 层次遍历
 * 2. 如何区分层 size+标志位
 */


//    1
//  2   3
// 4 5 6 7
public class PrintTree {
  public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    if (null == pRoot) {
      return new ArrayList<>();
    }
    ArrayList<ArrayList<Integer>> retList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    // 反向
    Stack<Integer> stack = new Stack<>();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(pRoot);
    boolean isDirect = true;
    boolean isFinish = true;
    int size = 0;
    while (!queue.isEmpty()) {
      if (isFinish) {
        size = queue.size();
        isFinish = false;
      }
      TreeNode poll = queue.poll();
      size--;

      if (isDirect) {
        list.add(poll.val);
      } else {
        stack.push(poll.val);
      }

      if (size == 0) {
        // 反向
        if (!isDirect)  {
          while (!stack.isEmpty()) {
            list.add(stack.pop());
          }
        }
        retList.add(new ArrayList<>(list));
        list.clear();
        isFinish = true;
        isDirect = !isDirect;
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
