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
		
		System.out.println("����ϵͳ\n����Ժ�С��ͬѧ����");
		Scanner input = new Scanner(System.in);
		int i = 0;
		StringBuffer question = new StringBuffer();// �û����������
		while (true) 
		{
			for (int j = 0; j < 80; j++)
				System.out.print("~");
			System.out.println();
			question.append(input.next());

			for (i = 0; i < question.length(); i++) {// �����������ݺ���Ӣ����ĸ������ѭ��
				if (question.charAt(i) > 'a' && question.charAt(i) < 'z'
						|| question.charAt(i) > 'A' && question.charAt(i) < 'A') {
					break;
				}
				;
			}
			if (i != question.length()) {// ��������ݺ���Ӣ����ĸ
				for (i = 0; i < question.length(); i++) {
					if (question.charAt(i) > 'a' && question.charAt(i) < 'z'
							|| question.charAt(i) > 'A' && question.charAt(i) < 'A') {
						question.deleteCharAt(i);// ɾ�����������ַ�
					}
					;
				}
			}

			StringBuffer content = new StringBuffer();// �洢������˵��������
			String strurl = apiUrl + question.toString();// ������ַ
			System.out.println(strurl);
			URL url = new URL(strurl);
			//inputStremReaderTest(url);
			// �����ڴ潫����ʾ
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
