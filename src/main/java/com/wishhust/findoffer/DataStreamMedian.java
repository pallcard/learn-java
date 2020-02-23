package com.wishhust.findoffer;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 1. 中位数：即把数据分为两个部分（大于中位数，小于中位数），
 * 2. 使用（1）最小堆：存放数据 （大于中位数的数）
 *       （2）最大堆：          （小于中位数的数）
 * 3. 插入： 若当前数据为偶数，前将数据插入最大堆，取出堆顶插入到最小堆中，=====》保证最小堆中数据大于最大堆中所有数据
 *           若当前数据为奇数，前将数据插入最小堆，取出堆顶插入到最大堆中，=====》保证最大堆中数据小于最小堆中所有数据
 *
 */
public class DataStreamMedian {
  private PriorityQueue<Integer> minHeap = new PriorityQueue<>();   // 默认小堆
  private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1,i2)->i2-i1);
  private int length = 0;
  public void Insert(Integer num) {
    if (length % 2 == 0) {
      maxHeap.add(num);
      Integer poll = maxHeap.poll();
      minHeap.add(poll);
    } else {
      minHeap.add(num);
      Integer poll = minHeap.poll();
      maxHeap.add(poll);
    }
    length++;
  }

  public Double GetMedian() {
    if (length % 2 == 1) {
      return (double) minHeap.peek();
    } else {
      return (double)(minHeap.peek() + maxHeap.peek()) / 2 ;
    }
  }

  public static void main(String[] args) {
    DataStreamMedian dataStreamMedian = new DataStreamMedian();
    dataStreamMedian.Insert(5);
    System.out.println(dataStreamMedian.GetMedian());
    dataStreamMedian.Insert(2);
    System.out.println(dataStreamMedian.GetMedian());
    dataStreamMedian.Insert(3);
    System.out.println(dataStreamMedian.GetMedian());
  }
}
