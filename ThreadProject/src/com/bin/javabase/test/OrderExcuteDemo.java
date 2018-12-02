package com.bin.javabase.test;
/**
 * 
* ��Ŀ���ƣ�ThreadProject   
* �����ƣ�OrderExcuteDemo   
* ��������˳��ִ���߳���ʾ
* �����ˣ������   
* ����ʱ�䣺2017��12��24�� ����11:45:45   
* @version 1.0
 */
public class OrderExcuteDemo {
	private static Thread t1 = new MyThread1();
	private static Thread t2 = new MyThread2();
	private static Thread t3 = new MyThread3();
	public static void main(String[] args) {
		
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}

	public static class MyThread1 extends Thread{
		public MyThread1() {
			super("�߳�1");
		}
		
		@Override
		public void run() {
			
			try {
				
				System.out.println(Thread.currentThread().getName() + "��������");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "�������");
		};
		
	}
	public static class MyThread2 extends Thread{
		public MyThread2() {
			super("�߳�2");
		}
		public void run() {
			
			try {
				t1.join();
				System.out.println(Thread.currentThread().getName() + "��������");
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "�������");
			
		};
		
	}
	public static class MyThread3 extends Thread{
		public MyThread3() {
			super("�߳�3");
		}
		public void run() {
			
			try {
				t2.join();
				System.out.println(Thread.currentThread().getName() + "��������");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "�������");
		};
		
	}
}
