package com.bin.javabase.aop;


import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {
	public void before() {
		System.out.println("前置增强");
	}
	
	public void after() {
		System.out.println("后置增强");
	}
	
	public void around(ProceedingJoinPoint point) {
		// 方法之前调用
		System.out.println("环绕之前");
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		// 方法之后调用
		System.out.println("环绕之后");
	}
}
