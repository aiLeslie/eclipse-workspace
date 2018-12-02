package com.bin.javabase.collectionDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesDemo {

	

	public static void main(String[] args) {
		//��ȡproperties�ļ���������
		Properties props = new Properties();
		//���������ļ� - �̶�д��
		try {
			props.load(PropertiesDemo.class.getResourceAsStream("config.properties"));
			//��ȡ����
			String value = props.getProperty("leslie",null);
			System.out.println(value);
			
			
			
			//�������ļ�д������
			props.setProperty("orientation", "������");
			
			FileOutputStream out = new FileOutputStream("bin/com/bin/javabase/collectionDemo/config.properties");
			props.store(out, "ע��");
			
			//�������м�ֵ��
			System.out.println("�������м�ֵ��");
			for (Entry<Object,Object> entry : props.entrySet()) {
				System.out.println(entry.getKey() + " & " + entry.getValue()); 
				
			}
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}

}
