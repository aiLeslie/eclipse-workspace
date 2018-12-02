package com.bin.javabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;


/**
 * 
 * 项目名称：Stream 类名称：ReadURLContent 类描述：从给定URL上读取文件内容-暂时支持HTTP协议 创建人：李玮斌
 * 创建时间：2017年10月29日 上午10:50:36
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
		// 参数url化
		String city = java.net.URLEncoder.encode("江门", "utf-8");

		// 拼地址
		String apiUrl = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s", city);
		URL url = new URL(apiUrl);
		StringBuffer content = new StringBuffer();
		// 将InputStream转换成Reader的套路:使用装饰器类InputSreamrReader
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
