package com.bin.javabase.NetworkCrawlerDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

public class NetworkCrawler {
	public static final String BAIDU_LINK = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=";
	private String rootUrl;
	private URL url;
	private BufferedReader buffReader = null;
	private StringBuffer content = new StringBuffer();

	public NetworkCrawler() {
		if (rootUrl == null || rootUrl.equals("")) {
			do {
				System.out.print("������Ҫ��ȡ��url:");
				rootUrl = new Scanner(System.in).next();
			} while (!(rootUrl
					.startsWith("http") /* && ((startUrl.endsWith(".com") || startUrl.endsWith(".html"))) */));
			try {
				start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public NetworkCrawler(String rootUrl) {
		this.rootUrl = rootUrl;
		while (!(rootUrl.startsWith("http") /* && ((startUrl.endsWith(".com") || startUrl.endsWith(".html"))) */)) {
			System.out.print("������Ҫ��ȡ��url:");
			rootUrl = new Scanner(System.in).next();
		}
		try {
			start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	private void start() {
		InputStreamReader inputStreamReader = null;
		String strUrl = null;
		// ��ַ���ڵ����δ������ַ����
		LinkQueue.addUnvisted(rootUrl);

		// δ������ַ���в�Ϊ�ռ�������
		while (!LinkQueue.getUnVistedUrl().isEmpty() && LinkQueue.getVistedUrl().size() <= LinkQueue.URL_SIZE) {
			try {
				// δ������ַ����Ԫ�س���
				strUrl = LinkQueue.getUnVistedUrl().poll();

				// ��ӡ���ʵ�ǰ��ַ��Ϣ
				for (int i = 0; i < 80; i++)
					System.out.print("-");
				System.out.println();
				System.out.println("~~~��ǰ����url:(" + strUrl + ")~~~");

				content.setLength(0);
				// ������
				this.url = new URL(strUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setReadTimeout(5000);
				connection.setConnectTimeout(5000);
				// ��ȡ��ַ����
				inputStreamReader = new InputStreamReader(connection.getInputStream(), "utf-8");
				buffReader = new BufferedReader(inputStreamReader);
				String line = null;
				while ((line = buffReader.readLine()) != null) {
					content.append(line);
					content.append(System.getProperty("line.separator"));
				}
				// System.out.println(content);

				String netCode = content.toString();
				// System.out.println(netCode);

				// ��ȡ������Ϣ
				int position = -1;
				while ((position = netCode.indexOf("href=\"", position)) != -1) {
					LinkQueue.addUnvisted(netCode.substring(position + "href=\"".length(),
							netCode.indexOf("\"", position + "href=\"".length() + 1)));
					// System.out.println(netCode.substring(position +
					// "href=\"".length(),netCode.indexOf("\"",position + "href=\"".length() + 1)));
					position++;
				}
				System.out.println();
				System.out.println("~~~����url:(" + strUrl + ")����~~~");
				for (int i = 0; i < 80; i++)
					System.out.print("-");
				// ��ǰ��ַ�����ѷ��ʶ���
				LinkQueue.getVistedUrl().add(strUrl);
				// �ر�����Դ
				buffReader.close();
				inputStreamReader.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 80; i++)
			System.out.print("-");
		System.out.println();
		System.out.println("��ȥ���ݽ���");
		try {

			for (int i = 0; i < 80; i++)
				System.out.print("^");
			System.out.println();
			System.out.println("��ȡ�õ���ַ");
			LinkQueue.getVistedUrl().forEach(action -> System.out.println(action));

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("." + "/urlData.txt"), true))) {
				for (int i = 0; i < 80; i++)
					writer.write("-");
				writer.write(System.getProperty("line.separator"));
				writer.write(new Date().toLocaleString());
				writer.write(System.getProperty("line.separator"));
				writer.write("������ڵ�: " + rootUrl);
				writer.write(System.getProperty("line.separator"));
				LinkQueue.getVistedUrl().forEach(action -> {
					try {
						writer.write(action);
						writer.write(System.getProperty("line.separator"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				for (int i = 0; i < 80; i++)
					writer.write("-");
				writer.write(System.getProperty("line.separator"));
				System.out.println("д��ɹ�");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void result(String keyword) {
		new NetworkCrawler(BAIDU_LINK + keyword);
	}

	public static void main(String[] args) {

//		new NetworkCrawler("https://www.so.com/s?ie=utf-8&src=se7_isearch&q=%E6%97%A5%E6%9C%AC%E7%90%86%E9%9F%B3");

		new NetworkCrawler(
				"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=���&rsv_pq=94bccb1f00011201&rsv_t=256aAKGBmx5q%2FpfTFaVj4MMsknEJkcjBv7a2ynMonSwjt9VaZXEJEm36ot4&rqlang=cn&rsv_enter=1&rsv_sug3=1");
	}

}
