package com.bin.javabase.test;

public class DeadLockDemo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		System.out.println("产生死锁现象");
		Example example = new Example();
		new DeadThread1(example).start();
		new DeadThread2(example).start();
		
	}

}

class DeadThread1 extends Thread{
	Example example = null;
	public DeadThread1(Example example) {
		this.example = example;
	}
	@Override
	public void run() {
		example.method1();
		
	}
}
class DeadThread2 extends Thread{
	Example example = null;
	public DeadThread2(Example example) {
		this.example = example;
	}
	@Override
	public void run() {
		example.method2();
	}
}
		
class Example{
	private Object obj1= new Object();
	private Object obj2= new Object();
	
	public void method1() {
		synchronized (obj1) {
			try {
				System.out.println(Thread.currentThread().getName() + "成功获得obj1的锁,等待obj2的锁");
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			synchronized (obj2) {
				System.out.println("method1" + "运行成功");
				
			}
		}
		
		
	}
	public void method2() {
		synchronized (obj2) {
			try {
				System.out.println(Thread.currentThread().getName() + "成功获得obj2的锁,等待obj1的锁");
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			synchronized (obj1) {
				System.out.println("method2" + "运行成功");
				
			}
		}
		
		
	}
}