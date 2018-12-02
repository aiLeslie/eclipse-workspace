package com.leslie.javabase;

public class RuntimeTest {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("最大可用内存" + runtime.maxMemory() / Math.pow(1024, 3) + "GB"); // 默认大小物理内存 1 / 4
		System.out.println("默认可用内存" + runtime.totalMemory() / Math.pow(1024, 2) + "MB"); // 默认大小物理内存 1 / 64
	}
}
