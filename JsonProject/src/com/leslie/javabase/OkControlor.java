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
	 * ���������ȡ����
	 * 
	 * @param String url(Ҫ���ʵ���ַ)
	 * @return String content (���������ص�����)
	 * @throws IOException
	 */
	public String stringBody(String url) {

		try {

			// ���ջ�Ӧ����
			Response response = sendRequest(url);

			if (checkReponse(response)) {
				// ���ؽ����ַ�������
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

					// ���ջ�Ӧ����
					Response response = sendRequest(url);

					if (checkReponse(response)) {
						// ���ؽ����ַ�������
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
	 * ��������������ݶ����ֽ����鲢����
	 * 
	 * @param InputStream in
	 * @return byte[] bytes
	 */
	public byte[] bytesBody(String url) {
		try {

			// ���ջ�Ӧ����
			Response response = sendRequest(url);

			if (checkReponse(response)) {
				// ���ؽ����ַ�������
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

					// ���ջ�Ӧ����
					Response response = sendRequest(url);

					if (checkReponse(response)) {
						// ���ؽ����ַ�������
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
			// ��������
			Request request = new Request.Builder().url(url).build();
			// ���ջ�Ӧ����
			Response response = client.newCall(request).execute();
			// ���ؽ����ַ�������
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
		// ������ַ�ɹ��ص�����
		public void onSucceed(String body);

		// ������ַʧ�ܻص�����
		public void onError();
	}

	public interface ByteHandler {
		// ������ַ�ɹ��ص�����
		public void onSucceed(byte[] body);

		// ������ַʧ�ܻص�����
		public void onError();
	}

	public void downloadRes(File file, byte[] body) {
		new Thread() {
			@Override
			public void run() {
				super.run();
				// �ֽ������
				OutputStream out = null;
				try {
					out = new FileOutputStream(file);
					out.write(body, 0, body.length);
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					if (out != null) {
						try {
							// �ر������
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
