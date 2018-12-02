package com.bin.javabase.test.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SigleThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService mSingleThreadPool = new ThreadPoolExecutor(1, 5,
                0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

		

		
		
		mSingleThreadPool.execute(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("½áÊø");
				while (true);
				
				

			}
		});
		
		mSingleThreadPool.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello");

			}
		});
	}
}
