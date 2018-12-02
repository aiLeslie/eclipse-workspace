package cn.bin.javabase;

import java.io.BufferedInputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
* 项目名称：Stream   
* 类名称：BinDownloader   
* 类描述：实现下载功能
* 创建人：李玮斌   
* 创建时间：2017年11月5日 下午3:40:31   
* @version 1.0
 */
public class BinDownloader {
	private final static String strUrl = "http://218.200.160.7/wlansst?pars=CI=6005660BDP72600907000007334405/F=020007/T=51153110130000/CH=2a257d4c-1ee0-4ad8-8081-b1650c26390a/S=9e9ea0ffb0/FN=%E6%97%A0%E5%BF%83%E7%9D%A1%E7%9C%A0+%28Remix%29.mp3";
	
	public static void main(String[] args) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestProperty("Range", "0-");
			switch(connection.getResponseCode() / 100 ) {
			  case 1:System.out.println("指示消息,表示请求已接收,继续操作");
			  	break;
			  case 2:System.out.println("成功,表示请求已被接受,操作");
			  
				BufferedInputStream in = new BufferedInputStream(connection.getInputStream()); 
			  byte[] content = new byte[connection.getInputStream().available()];
			  in.read(content);
			  RandomAccessFile file = new RandomAccessFile("163", "rw");
			  file.write(content);
			  System.out.println("下载成功");
			  /*try(FileOutputStream out = new FileOutputStream(new File("./张国荣.mp3"))){
				  out.write(content);
			  }*/
			  
			  
			  
			  	break;
			  case 3:System.out.println("重定向,要求完成请求必须进行进一步操作");
			  	break;
			  case 4:System.err.println("客户端错误,请求有语法错误或请求无法实现");
			  	return;
			  case 5:System.err.println("服务器错误,服务器未能实现合法请求");
			  	return;
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
