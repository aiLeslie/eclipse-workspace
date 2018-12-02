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
			System.out.println("�õ����ӷ���" + connection.getRequestMethod());
			System.out.println("�õ�����Ȩ��" + connection.getPermission());
			connection.setConnectTimeout(6 * 1000);//�����������ӳ�ʱʱ��
			connection.connect();//���ӿ�ʼ����
			System.out.println("�õ���Ӧ��Ϣ" + connection.getResponseMessage());
			if(!connection.getResponseMessage().equals("OK"))return;
			/**
			 * 1xx:ָʾ��Ϣ,��ʾ�����ѽ���,��������
			 * 2xx:�ɹ�,��ʾ�����ѱ�����,����
			 * 3xx:�ض���,Ҫ��������������н�һ������
			 * 4xx:�ͻ��˴���,�������﷨����������޷�ʵ��
			 * 5xx:����������,������δ��ʵ�ֺϷ�����
			 */
			System.out.println("�õ���Ӧ����" + connection.getResponseCode());
			
			
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
