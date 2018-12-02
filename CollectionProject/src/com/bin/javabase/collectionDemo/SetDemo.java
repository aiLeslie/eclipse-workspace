package com.bin.javabase.collectionDemo;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		final int length = 6;
		Set<String> set = new HashSet<>();
		set.add("h");
		set.add("e");
		set.add("l");
		set.add("l");
		set.add("o");
		String[] array = new String[length];
				set.toArray(array);
		for(String i : array)
		System.out.print(i);
		System.out.println();
	}

}
