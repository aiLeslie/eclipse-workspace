package com.bin.javabase.collectionDemo;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class ShowSystemProperties {

	public static void main(String[] args) {
		Properties properties = System.getProperties();
		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		entrySet.forEach(action->System.out.println(action.getKey() + " ~=~~~~~~~=~ " + action.getValue()));
		
		new Map.Entry<String, String>() {

			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getValue() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String setValue(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};

	}

}
