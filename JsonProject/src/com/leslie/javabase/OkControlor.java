package com.leslie.javabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkControlor {
	private OkHttpClient client = new OkHttpClient();

	public OkControlor() {
		super();
	}

	/**
	 * 向服务器获取数据
	 * 
	 * @param String url(要访问的网址)
	 * @return String content (服务器返回的内容)
	 * @throws IOException
	 */
	public String stringBody(String url) {

		try {

			// 接收回应内容
			Response response = sendRequest(url);

			if (checkReponse(response)) {
				// 返回接收字符串对象
				return response.body().string();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public void stringBodyAsync(String url, StrHandler handler) {
		new Thread() {

			@Override
			public void run() {

				super.run();

				try {

					// 接收回应内容
					Response response = sendRequest(url);

					if (checkReponse(response)) {
						// 返回接收字符串对象
						if (handler != null)
							handler.onSucceed(response.body().string());

					} else {
						if (handler != null)
							handler.onError();
					}

				} catch (IOException e) {
					e.printStackTrace();
					handler.onError();
				}

			}
		}.start();
	}

	/**
	 * 获得输入流把内容读到字节数组并返回
	 * 
	 * @param InputStream in
	 * @return byte[] bytes
	 */
	public byte[] bytesBody(String url) {
		try {

			// 接收回应内容
			Response response = sendRequest(url);

			if (checkReponse(response)) {
				// 返回接收字符串对象
				return response.body().bytes();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public void bytesBodyAsync(String url, ByteHandler handler) {
		new Thread() {
			@Override
			public void run() {

				super.run();

				try {

					// 接收回应内容
					Response response = sendRequest(url);

					if (checkReponse(response)) {
						// 返回接收字符串对象
						if (handler != null)
							handler.onSucceed(response.body().bytes());
					} else {
						if (handler != null)
							handler.onError();
					}

				} catch (IOException e) {
					e.printStackTrace();

				}

			}
		}.start();
	}

	private synchronized Response sendRequest(String url) {
		try {
			// 创建请求
			Request request = new Request.Builder().url(url).build();
			// 接收回应内容
			Response response = client.newCall(request).execute();
			// 返回接收字符串对象
			return response;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkReponse(Response response) {
		if (response != null) {

			return true;

		} else {

			return false;
		}
	}

	public interface StrHandler {
		// 访问网址成功回调方法
		public void onSucceed(String body);

		// 访问网址失败回调方法
		public void onError();
	}

	public interface ByteHandler {
		// 访问网址成功回调方法
		public void onSucceed(byte[] body);

		// 访问网址失败回调方法
		public void onError();
	}

	public void downloadRes(File file, byte[] body) {
		new Thread() {
			@Override
			public void run() {
				super.run();
				// 字节输出流
				OutputStream out = null;
				try {
					out = new FileOutputStream(file);
					out.write(body, 0, body.length);
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					if (out != null) {
						try {
							// 关闭输出流
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

			}
		}.start();

	}

}
