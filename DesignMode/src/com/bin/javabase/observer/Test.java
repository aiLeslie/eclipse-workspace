package com.bin.javabase.observer;

public class Test {
	public static void main(String[] args) {
		Subject subject = new Subject();
		new Observer(subject);
		
		subject.setState(10);
		
		subject.setState(20);
		
	}
}
