package com.bin.javabase.test;

public class WakeUpDemo {

	public static void main(String[] args) {
	
		WakeUpDemo demo = new WakeUpDemo();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "��������");
				try {
					synchronized (demo){
						demo.ThreadWait();
					}
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "�������");
			}
		});
		thread.start();
		Thread wkthread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "��������");
				boolean success = false;
				while(true)
				{
					if(!success && thread.isAlive() && thread.isInterrupted())try {
						synchronized (demo) {
							demo.notify();
							success = true;
							System.out.println(Thread.currentThread().getName() + "�������");
							break;
						}
						
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				}
				
			}
		});
		wkthread.start();
		
		
		
		
		
	}
	private synchronized void ThreadWait() {
		try {
			wait();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
/*public class WakeUpDemo {

	public static void main(String[] args) {

		final Object object = new Object();

		Thread t1 = new Thread() {

			public void run()

			{

				synchronized (object) {

					System.out.println("T1 start!");

					try {

						object.wait();

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

					System.out.println("T1 end!");

				}

			}

		};

		Thread t2 = new Thread() {

			public void run()

			{

				synchronized (object) {

					System.out.println("T2 start!");

					object.notify();

					System.out.println("T2 end!");

				}

			}

		};

		t1.start();

		t2.start();

	}

}*/