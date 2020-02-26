package com.wishhust.findoffer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class MultiplyArray {
  public int[] multiply(int[] A) {
    int [] B = new int[A.length];
    for (int i = 0; i < B.length; i++) {
      B[i] = multiplyExcludeIndex(A, i);
    }
    return B;
  }

  private int multiplyExcludeIndex(int[] A, int index) {
    int multiply = 1;
    for (int i = 0; i < A.length; i++) {
      if (index != i) {
        multiply *= A[i];
      }
    }
    return multiply;
  }

  public int[] multiply2(int[] A) {
    if (A.length <= 0) {
      return null;
    }
    int [] ret = new int[A.length];
    ret[0] = 1;
    for (int i = 1; i < A.length; i++) {
      ret[i] = ret[i-1]*A[i-1];
    }
    int temp = 1;
    for (int i = A.length-2; i >= 0; i--) {
      temp *= A[i+1];
      ret[i] = ret[i]*temp;
    }
    return ret;
  }

}
