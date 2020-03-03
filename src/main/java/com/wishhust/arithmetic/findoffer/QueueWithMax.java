package com.wishhust.arithmetic.findoffer;

import java.util.LinkedList;

public class QueueWithMax {

  private LinkedList<Integer> queue = new LinkedList();
  private LinkedList<Integer> maxQueue = new LinkedList();
// 1 2 3 3 1
  void push(int num) {
    while (!maxQueue.isEmpty() && maxQueue.getLast() < num) {
      maxQueue.pollLast();
    }
    maxQueue.add(num);
    queue.add(num);
  }

  int pop() throws Exception {
    if (queue.isEmpty()) {
      throw new Exception("队列已空");
    }
    Integer pop = queue.pop();
    if (!maxQueue.isEmpty() && pop.equals(maxQueue.peek())) {
      maxQueue.pop();
    }
    return pop;
  }

  int max() {
    return maxQueue.peek();
  }

  public static void main(String[] args) throws Exception {
    QueueWithMax queueWithMax = new QueueWithMax();
    queueWithMax.push(1);
    queueWithMax.push(2);
    queueWithMax.push(3);
    queueWithMax.push(1);
    System.out.println(queueWithMax.max());
    queueWithMax.pop();
    queueWithMax.pop();
    queueWithMax.pop();
    System.out.println(queueWithMax.max());


  }

}
