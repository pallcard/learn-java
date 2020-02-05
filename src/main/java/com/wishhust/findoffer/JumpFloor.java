package com.wishhust.findoffer;

public class JumpFloor {
  public int JumpFloor(int target) {
    if (target <= 2) {
      return target;
    }
    int j1 = 1;
    int j2 = 2;
    int result = 0;
    for (int i = 2; i < target; i++) {
      result = j1 + j2;
      j1 = j2;
      j2 = result;
    }
    return result;
  }
}
