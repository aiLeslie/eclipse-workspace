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
		//原始做法
		User user = new User();
		user.add();
	}
	

}
