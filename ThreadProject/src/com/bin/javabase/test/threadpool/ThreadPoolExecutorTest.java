package com.bin.javabase.test.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolExecutorTest {
	public static void main(String[] args) throws Exception {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, // corePoolSize在池中保存的线程数量，即使它们是空闲的，除非允许corethreadtimeout被设置
				1, // 最大限度地允许最大数量的线程数量池
				5, // 当线程的数量大于时，保持时间核心，这是多余的空闲线程的最大时间在终止前等待新任务。
				TimeUnit.SECONDS, // keepAliveTime参数的时间单元
				new LinkedBlockingDeque<>(), // 为keepAliveTime参数的时间单元
				new ThreadFactory() { // 工作队列队列用于在它们之前执行任务*执行。这个队列只容纳@code Runnable由@code execute方法提交的任务。

					@Override
					public Thread newThread(Runnable r) {

						System.out.println("新建线程");
						return null;
					}
				}, new ThreadPoolExecutor.DiscardOldestPolicy()); // 处理被阻塞时使用的处理程序因为线程边界和队列容量已经达到

		executor.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());

			}
		});
//		executor.shutdownNow();
		executor.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());

			}
		});
		
		

	}
}
