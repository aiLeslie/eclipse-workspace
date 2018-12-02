package cn.bin.javabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionTest {
	private static final String strurl = "http://www.baidu.com";

	public static void main(String[] args) {
		URL url = null;
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		
		try {

			url = new URL(strurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			System.out.println("得到链接方法" + connection.getRequestMethod());
			System.out.println("得到链接权限" + connection.getPermission());
			connection.setConnectTimeout(6 * 1000);//设置链接连接超时时间
			connection.connect();//链接开始连接
			System.out.println("得到回应信息" + connection.getResponseMessage());
			if(!connection.getResponseMessage().equals("OK"))return;
			/**
			 * 1xx:指示消息,表示请求已接收,继续操作
			 * 2xx:成功,表示请求已被接受,操作
			 * 3xx:重定向,要求完成请求必须进行进一步操作
			 * 4xx:客户端错误,请求有语法错误或请求无法实现
			 * 5xx:服务器错误,服务器未能实现合法请求
			 */
			System.out.println("得到回应代码" + connection.getResponseCode());
			
			
			inputStreamReader = new InputStreamReader(connection.getInputStream(),"UTF-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			String line = null;
			StringBuffer content = new StringBuffer();
			while((line = bufferedReader.readLine()) != null) {
				content.append(line);
				content.append(System.getProperty("line.separator"));
			}
			System.out.println(content.toString());
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
