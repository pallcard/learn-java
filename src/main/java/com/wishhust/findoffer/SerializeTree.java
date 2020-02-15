package com.wishhust.findoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 1. 结点值的形式（是否只是一个char）
 *
 */
public class SerializeTree {
  String Serialize(TreeNode root) {
    StringBuilder ret = new StringBuilder();
    if (null == root) {
      ret.append("#!");
      return ret.toString();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode poll = queue.poll();
      if (null == poll) {
        ret.append("#,");
        continue;
      } else {
        ret.append(poll.val+",");
      }
      queue.add(poll.left);
      queue.add(poll.right);
    }
    while (ret.toString().endsWith("#,")) {
      ret.delete(ret.length()-2, ret.length());
    }
    ret.append("#!");
    return ret.toString();
  }

  TreeNode Deserialize(String str) {
    if ("#!".equals(str)) {
      return null;
    }
    String[] strSplit = str.split(",");
    int index = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.parseInt(strSplit[index++]));
    queue.add(root);

    TreeNode left = null;
    TreeNode right = null;
    while (!queue.isEmpty() && index < strSplit.length-1) {
      TreeNode node = queue.poll();
      if (null != node) {
        if (strSplit[index].charAt(0) != '#') {
          left = new TreeNode(Integer.parseInt(strSplit[index++]));
        } else {
          left = null;
          index++;
        }
        queue.add(left);
        node.left = left;
        if (strSplit[index].charAt(0) != '#') {
          right = new TreeNode(Integer.parseInt(strSplit[index++]));
        } else {
          right = null;
          index++;
        }
        queue.add(right);
        node.right = right;
      }
    }
    return root;
  }

  public static void main(String[] args) {
//    TreeNode root = new SerializeTree().Deserialize("8,6,10,5,7,9,11,#!");
    TreeNode root = new SerializeTree().Deserialize("5,4,#,3,#,2,#!");
    String serialize = new SerializeTree().Serialize(root);
    System.out.println(serialize);
  }
}
