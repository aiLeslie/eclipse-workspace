package com.bin.javabase.test;
/**
 * 
* 项目名称：ThreadProject   
* 类名称：OrderExcuteDemo   
* 类描述：顺序执行线程演示
* 创建人：李玮斌   
* 创建时间：2017年12月24日 上午11:45:45   
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
			super("线程1");
		}
		
		@Override
		public void run() {
			
			try {
				
				System.out.println(Thread.currentThread().getName() + "正在运行");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "运行完毕");
		};
		
	}
	public static class MyThread2 extends Thread{
		public MyThread2() {
			super("线程2");
		}
		public void run() {
			
			try {
				t1.join();
				System.out.println(Thread.currentThread().getName() + "正在运行");
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "运行完毕");
			
		};
		
	}
	public static class MyThread3 extends Thread{
		public MyThread3() {
			super("线程3");
		}
		public void run() {
			
			try {
				t2.join();
				System.out.println(Thread.currentThread().getName() + "正在运行");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "运行完毕");
		};
		
	}
}
