package com.bin.javabase.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.bin.javabase.Test;

public class MyCollection {
	String[] array;
	List<Integer> list;
	HashMap<String, String> map;
	Properties properties;

	public void setArray(String[] array) {
		this.array = array;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public static void main(String[] args) {
		MyCollection instance = new Test<MyCollection>().getInstance("collection");
		System.out.println(instance);
		
		System.out.print("array: ");
		for (String string : instance.array) {
			System.out.print(string + ", ");
		}
		System.out.println();
		
		System.out.print("list: ");
		instance.list.forEach(action -> System.out.print(action + ", "));
		System.out.println();
		
		System.out.print("map: ");
		instance.map.entrySet().forEach(action -> {
			System.out.print(action.getKey() + " - " + action.getValue() + ", ");
		});
		System.out.println();
		
		System.out.print("properties: ");
		instance.properties.entrySet().forEach(action -> {
			System.out.print(action.getKey() + " - " + action.getValue() + ", ");
		});
		System.out.println();

	}

}
