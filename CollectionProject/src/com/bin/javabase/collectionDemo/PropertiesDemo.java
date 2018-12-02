package com.bin.javabase.collectionDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesDemo {

	

	public static void main(String[] args) {
		//读取properties文件常用作法
		Properties props = new Properties();
		//加载配置文件 - 固定写法
		try {
			props.load(PropertiesDemo.class.getResourceAsStream("config.properties"));
			//读取配置
			String value = props.getProperty("leslie",null);
			System.out.println(value);
			
			
			
			//向配置文件写入内容
			props.setProperty("orientation", "不爱你");
			
			FileOutputStream out = new FileOutputStream("bin/com/bin/javabase/collectionDemo/config.properties");
			props.store(out, "注释");
			
			//遍历所有键值对
			System.out.println("遍历所有键值对");
			for (Entry<Object,Object> entry : props.entrySet()) {
				System.out.println(entry.getKey() + " & " + entry.getValue()); 
				
			}
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}

}
