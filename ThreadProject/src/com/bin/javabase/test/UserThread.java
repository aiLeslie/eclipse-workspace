package com.bin.javabase.test;

public class UserThread {

	public UserThread() {
		
	}
	/**
	 * �û��߳� �����̴߳������߳�~���ػ��߳�
	 * �ػ��߳� �����߳�һ������
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ; i < 30;i++) {
					System.out.println("���߳�" + "-" + i + "��������");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					System.out.println("���߳�" + "-" + i + "�������");
				}
				
			}
		}).start();
		
		for(int i = 0 ; i < 5;i++) {
			System.out.println(Thread.currentThread().getName() + "~" + i + "��������");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "~" + i + "�������");
		}
		System.out.println("���߳�" + "�������");
	}

}
