package com.wishhust.base.concurrent;

import java.util.concurrent.locks.StampedLock;
// https://tech.meituan.com/2019/02/14/talk-about-java-magic-class-unsafe.html
public class StampedLockTest {

  private double x, y;

  private final StampedLock sl = new StampedLock();

  void move(double deltaX, double deltaY) {
    long stamp = sl.writeLock();
    try {
      x += deltaX;
      y += deltaY;

    } finally {
      sl.unlockWrite(stamp);
    }
  }

  double distanceFromOrigin() {
    long stamp = sl.tryOptimisticRead();
    double currentX = x, currentY = y;
    if (!sl.validate(stamp)) {
      stamp = sl.readLock();
      try {
        currentX = x;
        currentY = y;
      } finally {
        sl.unlockRead(stamp);
      }
    }
    return Math.sqrt(currentX*currentX + currentY*currentY);
  }
}
