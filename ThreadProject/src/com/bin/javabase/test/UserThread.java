package com.bin.javabase.test;

public class UserThread {

	public UserThread() {
		
	}
	/**
	 * 用户线程 是主线程创建的线程~非守护线程
	 * 守护线程 和主线程一起销毁
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ; i < 30;i++) {
					System.out.println("子线程" + "-" + i + "正在运行");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					System.out.println("子线程" + "-" + i + "运行完毕");
				}
				
			}
		}).start();
		
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
