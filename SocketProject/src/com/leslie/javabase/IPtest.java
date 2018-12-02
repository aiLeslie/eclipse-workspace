package com.leslie.javabase;

import java.net.InetAddress;

public class IPtest {
	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("主机名为: " + ip.getHostName());
			System.out.println("你的IP地址是: " + ip.getHostAddress());
			System.out.println(ip.getAddress());
			System.out.println("回调地址: " + InetAddress.getLoopbackAddress());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
