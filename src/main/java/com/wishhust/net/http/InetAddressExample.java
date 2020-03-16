package com.wishhust.net.http;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by liuke on 2019/12/19 17:02
 */
public class InetAddressExample {
  public static void main(String[] args) {
    //
    try {
      Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
      if (interfaces == null) {
        System.out.println("no interface");
      } else {
        while (interfaces.hasMoreElements()) {
          NetworkInterface iface = interfaces.nextElement();
          System.out.println("Interface " + iface.getName() + ":");
          Enumeration<InetAddress> addrList = iface.getInetAddresses();
          if (!addrList.hasMoreElements()) {
            System.out.println("no address for this interface");
          }
          while (addrList.hasMoreElements()) {
            InetAddress inetAddress = addrList.nextElement();
            System.out.println("address " + ((inetAddress instanceof Inet4Address)? "v4":(inetAddress instanceof Inet6Address)?"v6":"?"));
            System.out.println(inetAddress.getHostAddress());
          }
        }

      }
    } catch (SocketException e) {
      System.out.println("Error getting network interface:"+e.getMessage());
      e.printStackTrace();
    }

    for(String host : args) {
      try {
        System.out.println(host + ":");
        InetAddress[] addresses = InetAddress.getAllByName(host);
        for (InetAddress address : addresses) {
          System.out.println(address.getHostName() + "/" +address.getHostAddress());
        }
      } catch (UnknownHostException e) {
        System.out.println("unable to find address for "+host);
        e.printStackTrace();
      }
    }

  }
}
