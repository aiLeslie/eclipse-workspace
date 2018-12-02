package cn.bin.javabase;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PictureResource {
	public static void main(String[] args) {
		try {
			writePictureResource(".");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writePictureResource(String filePath) throws IOException {
		URL url = null;
		try {
			url = new URL("http://guolin.tech/api/bing_pic");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		StringBuffer content = new StringBuffer();
		// 将InputStream转换成Reader的套路:使用装饰器类InputSreamrReader
		try (Reader reader = new BufferedReader(new InputStreamReader(url.openStream()));) {
			String line = null;
			while ((line = ((BufferedReader) reader).readLine()) != null) {
				content.append(line);
				System.out.println(line);
				content.append(System.getProperty("line.separator"));
			}
			downloadPictrue(content.toString(), filePath);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void downloadPictrue(String strUrl, String filePath) {
		final int MAX_BUFFER_SIZE = 1024 * 8;

		// 1.打开http连接,获得下载内容的长度
		// 2.创建RandomAccessFile对象
		// 3.将下载内容缓存到字节数组
		// 4.将缓存字节数组通过RandomAccessFile对象写入到文件(涉及到文件指针的操作)
		HttpURLConnection connection = null;

		BufferedInputStream in = null;
		try {
			URL url = new URL(strUrl);
			connection = (HttpURLConnection) url.openConnection();

			/**
			 * 设置连接属性 - Range指从服务器下载文件的字节数范围, 0- 表示不终止字节数
			 */
			connection.setRequestProperty("Range", "bytes=0-");

			// 判断连接是否成功
			/**
			 * 1xx:指示消息,表示请求已接收,继续操作 2xx:成功,表示请求已被接受,操作 3xx:重定向,要求完成请求必须进行进一步操作
			 * 4xx:客户端错误,请求有语法错误或请求无法实现 5xx:服务器错误,服务器未能实现合法请求
			 */
			switch (connection.getResponseCode() / 100) {
			case 1:
				System.out.println("指示消息,表示请求已接收,继续操作");
				break;
			case 2:
				System.out.println("成功,表示请求已被接受,操作");
				break;
			case 3:
				System.out.println("重定向,要求完成请求必须进行进一步操作");
				break;
			case 4:
				System.out.println("客户端错误,请求有语法错误或请求无法实现");
				break;
			case 5:
				System.out.println("服务器错误,服务器未能实现合法请求");
				break;
			}
			if (connection.getResponseCode() / 100 != 2) {
				System.err.println("连接响应不在200范围内连接错误,请重试!");
				return;
			}

			int fileSize = connection.getContentLength();// 获得下载长度(单位字节)
			in = new BufferedInputStream(connection.getInputStream(), MAX_BUFFER_SIZE);
			int downloaded = 0;// 已下载字节数 - 用来计算下载百分比
			String fileName = url.getFile().substring(url.getFile().lastIndexOf("/") + 1);
			@SuppressWarnings("resource")
			RandomAccessFile file = new RandomAccessFile(filePath + "/" + fileName, "rw");
			file.setLength(0);
			file.seek(0);
			byte[] buffer = null;
			while (downloaded < fileSize) {

				// 判断未下载的大小是否超过最大缓存数
				if (fileSize - downloaded >= MAX_BUFFER_SIZE) {
					buffer = new byte[MAX_BUFFER_SIZE];
				} else {
					buffer = new byte[fileSize - downloaded];
				}
				long startTime = System.currentTimeMillis();
				int read = in.read(buffer);
				if (read == -1)
					break;
				file.seek(downloaded);
				// file.write(buffer,0,read);
				file.write(buffer);
				long endTime = System.currentTimeMillis() - startTime;
				downloaded += read;
				System.out.println();
				System.out.println("--------------");
				System.out.println("|当前下载进度:|");
				System.out.printf("|%.2f%%\n", ((float) downloaded / fileSize * 100));
				
				System.out.println("|当前下载速度:|");
				System.out.printf("|%.2fKB/S\n", (float)read * 1000 / Math.pow(1024, 1) /  endTime);
				System.out.println("--------------");

			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			connection.disconnect();
		}

	}

}
