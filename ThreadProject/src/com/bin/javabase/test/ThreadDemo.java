package com.bin.javabase.test;

import java.util.LinkedList;
import java.util.List;

public class ThreadDemo {

	public static void main(String[] args) {
		List<Thread> list = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new myThread("Ïß³Ì" + i));
		}

		list.forEach(action -> action.start());
		

		for (int i = 0; i < 10; i++) {
			new Thread(new myRunnable()).start();
		}
	}

	public static class myThread extends Thread {

		public myThread() {
			super();

		}

		public myThread(String arg0) {
			super(arg0);

		}

		@Override
		public void run() {
			
			System.out.println(Thread.currentThread().getName());

		}
	}

	public static class myRunnable implements Runnable {

		@Override
		public void run() {
			
			System.out.println(Thread.currentThread().getName());
		}

	}
}
