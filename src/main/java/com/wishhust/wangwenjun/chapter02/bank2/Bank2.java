package com.wishhust.wangwenjun.chapter02.bank2;

import com.wishhust.wangwenjun.chapter02.bank1.TicketWindowThread;

public class Bank2 {
  public static void main(String[] args) {
    // runnable接口将业务逻辑和线程控制进行分离
    TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();
    Thread t1 = new Thread(ticketWindowRunnable, "1号柜台");
    Thread t2 = new Thread(ticketWindowRunnable, "2号柜台");
    Thread t3 = new Thread(ticketWindowRunnable, "3号柜台");

    t1.start();
    t2.start();
    t3.start();
  }
}