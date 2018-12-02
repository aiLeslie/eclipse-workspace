package com.bin.javabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;


/**
 * 
 * ��Ŀ���ƣ�Stream �����ƣ�ReadURLContent ���������Ӹ���URL�϶�ȡ�ļ�����-��ʱ֧��HTTPЭ�� �����ˣ������
 * ����ʱ�䣺2017��10��29�� ����10:50:36
 * 
 * @version 1.0
 */
public class ReadURLContent {
	public static final String filePath = "src/cn/bin/javabase/read.txt";

	public ReadURLContent() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) throws Exception {
		// System.out.println("hello");
		// ����url��
		String city = java.net.URLEncoder.encode("����", "utf-8");

		// ƴ��ַ
		String apiUrl = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s", city);
		URL url = new URL(apiUrl);
		StringBuffer content = new StringBuffer();
		// ��InputStreamת����Reader����·:ʹ��װ������InputSreamrReader
		try (Reader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));) {
			String line = null;
			while ((line = ((BufferedReader) reader).readLine()) != null) {
				content.append(line);
				content.append(System.getProperty("line.separator"));
			}
			System.out.println(content.toString()/* .replace("{", "{\n") */);

		}
	}

}
