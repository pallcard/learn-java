package com.wishhust.wangwenjun.chapter02.bank1;

public class TicketWindowThread extends Thread{

  private final String name;
  private static final int MAX = 1000;
  private static int index = 1;// 考虑不为static情况

  public TicketWindowThread(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    while (index <= MAX){
      System.out.println(name + "当前的号码是：" + (index++));
    }
  }
}