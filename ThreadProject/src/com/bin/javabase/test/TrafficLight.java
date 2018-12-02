package com.bin.javabase.test;

public class TrafficLight {
	public static void main(String[] args) {
		new Light().start();
		new Person().start();
	}
}

class Light extends Thread {
	static boolean isGreen;

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 30; i++) {
			if (i % 2 == 0) {

				isGreen = true;
				System.out.println("绿灯亮");

			} else {
				isGreen = false;
				System.out.println("红灯亮");
			}
			synchronized (Person.class) {
				Person.class.notify();
			}
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Person extends Thread {

	static synchronized void setState() throws InterruptedException {

		if (Light.isGreen) {
			System.out.println("行人走动");

		} else {
			System.out.println("行人等待");

		}

		Person.class.wait();
	}

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 1000; i++) {

			try {
				setState();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
