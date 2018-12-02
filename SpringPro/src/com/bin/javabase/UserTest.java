package com.bin.javabase;


import com.bin.javabase.bean.User;

public class UserTest {
	public static void main(String[] args) {
		User instance = new Test<User>("Annotation.xml").getInstance("user");
		System.out.println(instance);
	}
}
