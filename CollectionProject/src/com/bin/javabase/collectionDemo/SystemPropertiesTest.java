package com.bin.javabase.collectionDemo;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;



public class SystemPropertiesTest {

	public static void main(String[] args) {
		Properties properties = System.getProperties();
		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		System.out.println("系统属性有"+ entrySet.size() + "个");
		entrySet.forEach(action -> System.out.println(action.getKey() + " -- " + action.getValue()));

		

	}

}
