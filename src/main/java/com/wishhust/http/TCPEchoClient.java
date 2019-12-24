package com.wishhust.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by liuke on 2019/12/19 17:35
 */
public class TCPEchoClient {
  public static void main(String[] args) throws IOException {
    //
    if (args.length < 2 || args.length > 3) {
      throw new IllegalArgumentException("Parameter(s): <Server> <Word> []");
    }

    String server = args[0];

    byte[] data = args[1].getBytes();

    int servProt = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

    Socket socket = new Socket(server, servProt);
    System.out.println("Connected to service ... sending echo string");

    InputStream inputStream = socket.getInputStream();
    OutputStream outputStream = socket.getOutputStream();

    outputStream.write(data);

    int totalByteRcvd = 0;
    int bytesRcvd;
    while (totalByteRcvd < data.length) {
      if ((bytesRcvd = inputStream.read(data, totalByteRcvd, data.length-totalByteRcvd)) == -1) {
        throw  new SocketException("connection closed prematurely");
      }
      totalByteRcvd += bytesRcvd;
    }

    System.out.println("Received: " + new String(data));
    socket.close();
  }
}
