package com.wishhust.arithmetic.findoffer;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 1. 对称遍历
 *     先序遍历 根左右
 * 对称先序遍历 根右左
 * 2. 以上两个遍历要相等
 */

//         1
//     2        2
//   3   4    4   3
//  5 6 7 8  8 7 6 5


public class IsSymmetricalTree {
  boolean isSymmetrical(TreeNode pRoot) {
    if (null == pRoot) {
      return true;
    }
    return isSymmetrical(pRoot, pRoot);
  }
  boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
    if (pRoot1 == null && pRoot2 == null) {
      return true;
    }
    if (pRoot1 == null || pRoot2 == null) {
      return false;
    }

    // 根1  根2
    if (pRoot1.val == pRoot2.val) {
    //                      左1   右2                                  // 右1  左2
      return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    } else {
      return false;
    }

  }
}
