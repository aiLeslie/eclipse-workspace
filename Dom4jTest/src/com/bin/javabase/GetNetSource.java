package com.bin.javabase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class GetNetSource {
	public static void main(String[] args) {
		URL url = null;
		InputStream in = null;
		FileOutputStream out = null;
		try {
			url = new URL("http://www.163.com");
			in = url.openStream();
			byte[] bytes = new byte[in.available()];
			in.read(bytes);
			out = new FileOutputStream("./data.xml");
			out.write(bytes);
			System.out.println("读取网络信息成功");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
