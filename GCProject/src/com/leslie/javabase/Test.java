package com.leslie.javabase;

import java.lang.ref.WeakReference;

public class Test {
	public static void main(String[] args) {
		class Hello{
			String hi = "HelloWorld!"; // 常量池中的字符串
//			Hello me = this;
		}
		
		WeakReference<Hello> wr = new WeakReference<>(new Hello());
		String str = wr.get().hi;
//		Hello me = wr.get().me;
		
		System.gc();
		System.runFinalization();
		
//		System.out.println(me);
		System.out.println(str);
		System.out.println(wr.get());
	}
}
