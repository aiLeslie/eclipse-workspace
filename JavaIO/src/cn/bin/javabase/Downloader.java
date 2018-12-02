package cn.bin.javabase;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;





/**
 * 
* ��Ŀ���ƣ�Stream   
* �����ƣ�Downloader   
* �������������ļ���
* �����ˣ������   
* ����ʱ�䣺2017��11��4�� ����6:29:14   
* @version 1.0
* 
* ����ԭ��:
* InputStream -> BufferedInputStream
* 1.��ǰ������Ҫʵ��httpЭ��(���ı�Э��)�����ļ�
* 
* 2.�����������ݷֿ�д��Ӳ����(ʹ��RandomAccessFile��ʵ��
 */
public class Downloader {
	//�ļ���С146M
	private final static String strUrl = "http://m10.music.126.net/20180209010724/794db85f0a409b1d94a0dd001541abc8/ymusic/8737/2f43/d01d/6c6b4c6e98011d5c75504fb85b254fcb.mp3";
	//��������ʱ�Ļ����С - 1M��С/10k
	private static final int MAX_BUFFER_SIZE = 1024 * 1024;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//1.��http����,����������ݵĳ���
		//2.����RandomAccessFile����
		//3.���������ݻ��浽�ֽ�����
		//4.�������ֽ�����ͨ��RandomAccessFile����д�뵽�ļ�(�漰���ļ�ָ��Ĳ���)
		HttpURLConnection connection = null;
		
		BufferedInputStream in= null; 
		try {
			URL url = new URL(strUrl);
			connection = (HttpURLConnection)url.openConnection();
			
			/**
			 * ������������ - Rangeָ�ӷ����������ļ����ֽ�����Χ, 0- ��ʾ����ֹ�ֽ���
			 */
			connection.setRequestProperty("Range","bytes=0-");
			
			//�ж������Ƿ�ɹ�
			/**
			 * 1xx:ָʾ��Ϣ,��ʾ�����ѽ���,��������
			 * 2xx:�ɹ�,��ʾ�����ѱ�����,����
			 * 3xx:�ض���,Ҫ��������������н�һ������
			 * 4xx:�ͻ��˴���,�������﷨����������޷�ʵ��
			 * 5xx:����������,������δ��ʵ�ֺϷ�����
			 */
			switch(connection.getResponseCode() / 100 ) {
			  case 1:System.out.println("ָʾ��Ϣ,��ʾ�����ѽ���,��������");
			  	break;
			  case 2:System.out.println("�ɹ�,��ʾ�����ѱ�����,����");
			  	break;
			  case 3:System.out.println("�ض���,Ҫ��������������н�һ������");
			  	break;
			  case 4:System.out.println("�ͻ��˴���,�������﷨����������޷�ʵ��");
			  	break;
			  case 5:System.out.println("����������,������δ��ʵ�ֺϷ�����");
			  	break;
			}
			if(connection.getResponseCode() / 100 != 2) {
				System.err.println("������Ӧ����200��Χ�����Ӵ���,������!");
				return;
			}
			
			int fileSize = connection.getContentLength();//������س���(��λ�ֽ�)
			in = new BufferedInputStream(connection.getInputStream(),MAX_BUFFER_SIZE);
			int downloaded = 0;//�������ֽ��� - �����������ذٷֱ�
			String fileName = url.getFile().substring(url.getFile().lastIndexOf("/") + 1);
			RandomAccessFile file = new RandomAccessFile(fileName,"rw");
			file.setLength(0);
			file.seek(0);
			byte[] buffer= null;
			while(downloaded < fileSize) {
				
				 //Object obj = System.console();
				 
				
				//�ж�δ���صĴ�С�Ƿ񳬹���󻺴���
				if(fileSize - downloaded >= MAX_BUFFER_SIZE) {
					buffer = new byte[MAX_BUFFER_SIZE];
				}else {
					buffer = new byte[fileSize - downloaded];
				}
				long startTime = System.currentTimeMillis();
				int read = in.read(buffer);
				if(read == -1)break;
				file.seek(downloaded);
				//file.write(buffer,0,read);
				file.write(buffer);
				long endTime = System.currentTimeMillis();
				downloaded += read;
				System.out.println();
				System.out.println("--------------");
				System.out.println("|��ǰ���ؽ���:|");
				System.out.printf("|%.2f%%\n",((float)downloaded / fileSize * 100));
				System.out.println("|��ǰ�����ٶ�:|");
				//System.out.printf("|%.2fkB/S\n",( (new BigDecimal(read + "").divide(new BigDecimal(Math.pow(1024, 2) + "")) ).divide(new BigDecimal(endTime + "").divide(new BigDecimal(1000 + "")))).floatValue());
				System.out.printf("|%.2fMB/S\n",(float)read / Math.pow(1024, 2) / (endTime - startTime) * 1000);
				System.out.println("--------------");
				
			}
			System.out.println("�ļ�MIME����:" + URLConnection.getFileNameMap().getContentTypeFor("./" + fileName));
			
			 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}finally {
			try {
				if(in != null)
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			connection.disconnect();
		}
		
	}
	
	
}
