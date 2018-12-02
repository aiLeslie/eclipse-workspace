package com.bin.javabase.test;

public class JoinMethodTest {

public static void main(String[] args) {
			Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ; i < 10;i++) {
					System.out.println("子线程" + "-" + i + "正在运行");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					System.out.println("子线程" + "-" + i + "运行完毕");
				}
				
			}
		});
			thread.start();
		try {
			thread.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for(int i = 0 ; i < 5;i++) {
			System.out.println(Thread.currentThread().getName() + "~" + i + "正在运行");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "~" + i + "运行完毕");
		}
		System.out.println("主线程" + "运行完毕");
	}

	

}
