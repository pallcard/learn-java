package com.wishhust.arithmetic.findoffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */


public class VerifySquenceOfBST {

  public boolean VerifySquenceOfBST(int [] sequence) {

    int length;
    if (sequence == null || (length = sequence.length) == 0) {
      return false;
    }
    return VerifySquenceOfBST(sequence, 0,  length-1);
  }

  public boolean VerifySquenceOfBST(int [] sequence, int start, int end) {
    if (start >= end) {
      return true;
    }
    int leftIndex = start;
    int root = sequence[end];
    while (leftIndex <= end) {
      if (sequence[leftIndex] < root) {
        leftIndex++;
      } else {
        break;
      }
    }

    int rightIndex = leftIndex;
    while (rightIndex < end) {
      if (sequence[rightIndex] > root) {
        rightIndex++;
      } else {
        return false;
      }
    }

    if (leftIndex-1-start == 0 && end-1-leftIndex==0) {
      return true;
    }

    return VerifySquenceOfBST(sequence, start, leftIndex-1)
        && VerifySquenceOfBST(sequence, leftIndex, end-1);
  }




  //非递归
  //非递归也是一个基于递归的思想：
  //左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
  //最后一个数字是右子树的根他也比左子树所有值大，因此我们可以每次只看有子树是否符合条件
  //即可，即使到达了左子树左子树也可以看出由左右子树组成的树还想右子树那样处理
  //对于左子树回到了原问题，对于右子树，左子树的所有值都比右子树的根小可以暂时把他看出右子树的左子树
  //只需看看右子树的右子树是否符合要求即可

  public boolean VerifySquenceOfBST2(int[] sequence) {
    int size = sequence.length;
    if (0 == size) {
      return false;
    }

    int i = 0;
    while (--size > 0) {
      while (sequence[i++] < sequence[size]) {

      }
      while (sequence[i++] > sequence[size]) {

      }

      if (i < size) {
        return false;
      }
      i = 0;
    }
    return true;
  }

  public static void main(String[] args) {
//    boolean b = new VerifySquenceOfBST().VerifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8});
    boolean b = new VerifySquenceOfBST().VerifySquenceOfBST(new int[]{});
    System.out.println(b);
  }

}
