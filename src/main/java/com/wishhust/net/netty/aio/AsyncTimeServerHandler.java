package com.wishhust.net.netty.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable {

  private int port;
  CountDownLatch latch;
  AsynchronousServerSocketChannel asynchronousServerSocketChannel;

  public AsyncTimeServerHandler(int port) {
    this.port = port;
    try {
      asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
      asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
      System.out.println("The time server is start in port:" +port);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void run() {
    latch = new CountDownLatch(1);
    doAccept();
    try {
      // 完成一组正在执行的操作之前，允许当前线程一直阻塞，实际项目中不需要
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void doAccept() {
    asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandle());
  }


}
