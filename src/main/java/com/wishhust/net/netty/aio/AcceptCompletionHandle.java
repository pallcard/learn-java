package com.wishhust.net.netty.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandle implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {


  @Override
  public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
    // 再次调用accept去接受新的客户端
    attachment.asynchronousServerSocketChannel.accept(attachment, this);
    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    result.read(byteBuffer, byteBuffer, new ReadCompletionHandler(result));
  }

  @Override
  public void failed(Throwable exc, AsyncTimeServerHandler attachment) {

  }

}
