package com.leslie.javabase;

public class RuntimeTest {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("�������ڴ�" + runtime.maxMemory() / Math.pow(1024, 3) + "GB"); // Ĭ�ϴ�С�����ڴ� 1 / 4
		System.out.println("Ĭ�Ͽ����ڴ�" + runtime.totalMemory() / Math.pow(1024, 2) + "MB"); // Ĭ�ϴ�С�����ڴ� 1 / 64
	}
}
