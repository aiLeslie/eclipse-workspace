package cn.bin.javabase.chapter0;

import java.io.File;

public class OverrideMethodMakeDifferentClass {

	public static void main(String[] args) {
		System.out.println(new Object().getClass().equals(new Object() /*{@Override
		public String toString() {
			
			return super.toString();
		}}*/.getClass()));
		System.out.println(new File(".").getAbsolutePath().equals(new File("cn.bin.javabase.chapter0").getAbsolutePath()));
		

	}

}
