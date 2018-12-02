package com.bin.javabase.test;

class RunnableDemo implements Runnable {
	int counter;
	static ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<Integer>();

	public void run() {
		counter++;
		if (threadLocalCounter.get() != null) {
			threadLocalCounter.set(threadLocalCounter.get().intValue() + 1);
		} else {
			threadLocalCounter.set(0);
		}
		
		System.out.println(Thread.currentThread().getName() + ":" + "Counter: " + counter);
		System.out.println(Thread.currentThread().getName() + ":" + "threadLocalCounter: " + threadLocalCounter.get());
		
		threadLocalCounter.set(1);
	}
}

public class TestThread {

	public static void main(String args[]) {
		RunnableDemo commonInstance = new RunnableDemo();

		Thread t1 = new Thread(commonInstance);
		Thread t2 = new Thread(commonInstance);
		Thread t3 = new Thread(commonInstance);
		Thread t4 = new Thread(commonInstance);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		

		// wait for threads to end
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			
			System.out.println(RunnableDemo.threadLocalCounter.get());
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
	}
}