package com.wishhust.arithmetic.findoffer;


import java.util.LinkedList;
import java.util.Queue;

public class StackByQueue {
  Queue<Integer> queue1 = new LinkedList<>();
  Queue<Integer> queue2 = new LinkedList<>();

  public void push(int e) {
    if(!queue2.isEmpty()) {
      queue2.add(e);
    } else {
      queue1.add(e);
    }
  }

  public int pop() {
    if (queue1.isEmpty()) {
      while (queue2.size()>1) {
        queue1.add(queue2.poll());
      }
      return queue2.poll();
    } else {
      while (queue1.size()>1) {
        queue2.add(queue1.poll());
      }
      return queue1.poll();
    }
  }

  public static void main(String[] args) {
    StackByQueue stackByQueue = new StackByQueue();
    stackByQueue.push(1);
    stackByQueue.push(2);
    stackByQueue.push(3);
    System.out.println(stackByQueue.pop());
    System.out.println(stackByQueue.pop());
    stackByQueue.push(4);
    System.out.println(stackByQueue.pop());
    System.out.println(stackByQueue.pop());
  }

}
