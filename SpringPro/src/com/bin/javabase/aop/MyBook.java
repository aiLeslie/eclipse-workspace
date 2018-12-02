package com.bin.javabase.aop;


import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {
	public void before() {
		System.out.println("ǰ����ǿ");
	}
	
	public void after() {
		System.out.println("������ǿ");
	}
	
	public void around(ProceedingJoinPoint point) {
		// ����֮ǰ����
		System.out.println("����֮ǰ");
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		// ����֮�����
		System.out.println("����֮��");
	}
}
