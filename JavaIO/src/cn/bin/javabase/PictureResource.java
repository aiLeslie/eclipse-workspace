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
		// ��InputStreamת����Reader����·:ʹ��װ������InputSreamrReader
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

		// 1.��http����,����������ݵĳ���
		// 2.����RandomAccessFile����
		// 3.���������ݻ��浽�ֽ�����
		// 4.�������ֽ�����ͨ��RandomAccessFile����д�뵽�ļ�(�漰���ļ�ָ��Ĳ���)
		HttpURLConnection connection = null;

		BufferedInputStream in = null;
		try {
			URL url = new URL(strUrl);
			connection = (HttpURLConnection) url.openConnection();

			/**
			 * ������������ - Rangeָ�ӷ����������ļ����ֽ�����Χ, 0- ��ʾ����ֹ�ֽ���
			 */
			connection.setRequestProperty("Range", "bytes=0-");

			// �ж������Ƿ�ɹ�
			/**
			 * 1xx:ָʾ��Ϣ,��ʾ�����ѽ���,�������� 2xx:�ɹ�,��ʾ�����ѱ�����,���� 3xx:�ض���,Ҫ��������������н�һ������
			 * 4xx:�ͻ��˴���,�������﷨����������޷�ʵ�� 5xx:����������,������δ��ʵ�ֺϷ�����
			 */
			switch (connection.getResponseCode() / 100) {
			case 1:
				System.out.println("ָʾ��Ϣ,��ʾ�����ѽ���,��������");
				break;
			case 2:
				System.out.println("�ɹ�,��ʾ�����ѱ�����,����");
				break;
			case 3:
				System.out.println("�ض���,Ҫ��������������н�һ������");
				break;
			case 4:
				System.out.println("�ͻ��˴���,�������﷨����������޷�ʵ��");
				break;
			case 5:
				System.out.println("����������,������δ��ʵ�ֺϷ�����");
				break;
			}
			if (connection.getResponseCode() / 100 != 2) {
				System.err.println("������Ӧ����200��Χ�����Ӵ���,������!");
				return;
			}

			int fileSize = connection.getContentLength();// ������س���(��λ�ֽ�)
			in = new BufferedInputStream(connection.getInputStream(), MAX_BUFFER_SIZE);
			int downloaded = 0;// �������ֽ��� - �����������ذٷֱ�
			String fileName = url.getFile().substring(url.getFile().lastIndexOf("/") + 1);
			@SuppressWarnings("resource")
			RandomAccessFile file = new RandomAccessFile(filePath + "/" + fileName, "rw");
			file.setLength(0);
			file.seek(0);
			byte[] buffer = null;
			while (downloaded < fileSize) {

				// �ж�δ���صĴ�С�Ƿ񳬹���󻺴���
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
				System.out.println("|��ǰ���ؽ���:|");
				System.out.printf("|%.2f%%\n", ((float) downloaded / fileSize * 100));
				
				System.out.println("|��ǰ�����ٶ�:|");
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
