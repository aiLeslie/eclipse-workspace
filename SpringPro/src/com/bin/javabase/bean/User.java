package com.bin.javabase.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("user")
@Scope("prototype")
public class User {
	public void add() {
		System.out.println("add success");
	}
	public static void main(String[] args) {
		//ԭʼ����
		User user = new User();
		user.add();
	}
	

}
