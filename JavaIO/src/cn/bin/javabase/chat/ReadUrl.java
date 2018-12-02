package cn.bin.javabase.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ReadUrl {
	private static final String apiUrl = "http://www.tuling123.com/openapi/api?key=a0fbf366339c42278d985f5ed6499ac9&info=";
	public static void main(String[] args) throws Exception {
		
		System.out.println("聊天系统\n你可以和小爱同学聊天");
		Scanner input = new Scanner(System.in);
		int i = 0;
		StringBuffer question = new StringBuffer();// 用户输入的内容
		while (true) 
		{
			for (int j = 0; j < 80; j++)
				System.out.print("~");
			System.out.println();
			question.append(input.next());

			for (i = 0; i < question.length(); i++) {// 如果输入的内容含有英语字母就跳出循环
				if (question.charAt(i) > 'a' && question.charAt(i) < 'z'
						|| question.charAt(i) > 'A' && question.charAt(i) < 'A') {
					break;
				}
				;
			}
			if (i != question.length()) {// 输入的内容含有英语字母
				for (i = 0; i < question.length(); i++) {
					if (question.charAt(i) > 'a' && question.charAt(i) < 'z'
							|| question.charAt(i) > 'A' && question.charAt(i) < 'A') {
						question.deleteCharAt(i);// 删除该索引的字符
					}
					;
				}
			}

			StringBuffer content = new StringBuffer();// 存储机器人说话的内容
			String strurl = apiUrl + question.toString();// 制造网址
			System.out.println(strurl);
			URL url = new URL(strurl);
			//inputStremReaderTest(url);
			// 读入内存将其显示
			try (Reader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));) {
				// System.out.println(reader.hashCode());
				String line = null;
				while ((line = ((BufferedReader) reader).readLine()) != null) {
					if (line.equals("exit")) {
						input.close();
						break;
					}
					System.out.println(line);
					System.out.println(line.substring(line.lastIndexOf(':') + 2, line.lastIndexOf('"')));
					content.append(line);
					content.append(System.getProperty("line.separator"));
				}

				for (int j = 0; j < 80; j++)
					System.out.print("~");
				System.out.println();
				
			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				question.setLength(0);
				
			}
		}
	}
	public static void inputStremReaderTest(URL url) throws IOException {
		InputStream in = null;
		try {
			in = url.openStream();
			byte [] bytes = new byte[in.available()];
			in.read(bytes);
			System.out.println(new String(bytes));
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			in.close();
		}
	}
}
