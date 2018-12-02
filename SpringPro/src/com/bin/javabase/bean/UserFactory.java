package com.bin.javabase.bean;

public class UserFactory {
	// 使用静态方法创建对象
	public static User createUser() {
		return new User();
	}
	
	// 使用成员方法创建对象
	public  User getUser() {
		return new User();
	}
}
