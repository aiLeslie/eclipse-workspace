package com.bin.javabase.aop;

import org.apache.log4j.Logger;

import com.bin.javabase.Test;

public class Book {
	public static Logger logger = Logger.getLogger("log4j");

	public void add() {
		System.out.println("add >>>>>>>>>>>>>>>>");
	}

	public static void main(String[] args) {
		Book instance = new Test<Book>("AOP.xml").getInstance("book");
		instance.add();
	}
}
