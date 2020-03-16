package com.wishhust.net.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable {
  private Selector selector;
  private ServerSocketChannel servChannel;
  private volatile boolean stop;

  public MultiplexerTimeServer(int port) {
    try {
      selector = Selector.open();
      servChannel = ServerSocketChannel.open();
      servChannel.configureBlocking(false);
      servChannel.socket().bind(new InetSocketAddress(port), 1024);
      System.out.println("The time server is start in port : "+ port);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  public void stop() {
    this.stop = true;
  }


  @Override
  public void run() {
    while (!stop) {
      try {
        selector.select(1000);
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> it = selectionKeys.iterator();
        SelectionKey key = null;
        while (it.hasNext()) {
          key = it.next();
          try {
            handleInput(key);
          } catch (IOException e) {
            if (key != null) {
              key.cancel();
              if (key.channel() != null) {
                key.channel().close();
              }
            }
            e.printStackTrace();
          }
        }
      } catch (Throwable t) {
        t.printStackTrace();
      }

    }
  }

  private void handleInput(SelectionKey key) throws IOException {
    if (key.isValid()) {

      if (key.isAcceptable()) {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssc.accept();
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ);
      }

      if (key.isReadable()) {
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int readBytes = sc.read(readBuffer);
        if (readBytes > 0) {
          readBuffer.flip();
          byte[] bytes = new byte[readBuffer.remaining()];
          readBuffer.get(bytes);
          String body = new String(bytes, "UTF-8");
          System.out.println("The time server receive order :" + body);
          String currentTime = "Query time order".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() :
              "Bad order";
          doWrite(sc, currentTime);
        } else if (readBytes < 0) {
          key.channel();
          sc.close();
        }
      }

    }
  }

  private void doWrite(SocketChannel sc, String response) throws IOException {
    if (response != null && response.trim().length() > 0) {
      byte[] bytes = response.getBytes();
      ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
      writeBuffer.put(bytes);
      writeBuffer.flip();
      sc.write(writeBuffer);
    }
  }
}
