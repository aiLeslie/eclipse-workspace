package com.bin.javabase.collectionDemo;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;



public class SystemPropertiesTest {

	public static void main(String[] args) {
		Properties properties = System.getProperties();
		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		System.out.println("ϵͳ������"+ entrySet.size() + "��");
		entrySet.forEach(action -> System.out.println(action.getKey() + " -- " + action.getValue()));

		

	}

}
