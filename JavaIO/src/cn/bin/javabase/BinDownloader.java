package cn.bin.javabase;

import java.io.BufferedInputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
* ��Ŀ���ƣ�Stream   
* �����ƣ�BinDownloader   
* ��������ʵ�����ع���
* �����ˣ������   
* ����ʱ�䣺2017��11��5�� ����3:40:31   
* @version 1.0
 */
public class BinDownloader {
	private final static String strUrl = "http://218.200.160.7/wlansst?pars=CI=6005660BDP72600907000007334405/F=020007/T=51153110130000/CH=2a257d4c-1ee0-4ad8-8081-b1650c26390a/S=9e9ea0ffb0/FN=%E6%97%A0%E5%BF%83%E7%9D%A1%E7%9C%A0+%28Remix%29.mp3";
	
	public static void main(String[] args) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestProperty("Range", "0-");
			switch(connection.getResponseCode() / 100 ) {
			  case 1:System.out.println("ָʾ��Ϣ,��ʾ�����ѽ���,��������");
			  	break;
			  case 2:System.out.println("�ɹ�,��ʾ�����ѱ�����,����");
			  
				BufferedInputStream in = new BufferedInputStream(connection.getInputStream()); 
			  byte[] content = new byte[connection.getInputStream().available()];
			  in.read(content);
			  RandomAccessFile file = new RandomAccessFile("163", "rw");
			  file.write(content);
			  System.out.println("���سɹ�");
			  /*try(FileOutputStream out = new FileOutputStream(new File("./�Ź���.mp3"))){
				  out.write(content);
			  }*/
			  
			  
			  
			  	break;
			  case 3:System.out.println("�ض���,Ҫ��������������н�һ������");
			  	break;
			  case 4:System.err.println("�ͻ��˴���,�������﷨����������޷�ʵ��");
			  	return;
			  case 5:System.err.println("����������,������δ��ʵ�ֺϷ�����");
			  	return;
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
