package com.wishhust.findoffer;

public class JumpFloorII {

  public int JumpFloorII(int target) {
    if (target <= 2) {
      return target;
    }
    return (int)Math.pow(2.0, target-1);
  }
}
