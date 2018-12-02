package com.bin.javabase.test.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolExecutorTest {
	public static void main(String[] args) throws Exception {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, // corePoolSize�ڳ��б�����߳���������ʹ�����ǿ��еģ���������corethreadtimeout������
				1, // ����޶ȵ���������������߳�������
				5, // ���̵߳���������ʱ������ʱ����ģ����Ƕ���Ŀ����̵߳����ʱ������ֹǰ�ȴ�������
				TimeUnit.SECONDS, // keepAliveTime������ʱ�䵥Ԫ
				new LinkedBlockingDeque<>(), // ΪkeepAliveTime������ʱ�䵥Ԫ
				new ThreadFactory() { // �������ж�������������֮ǰִ������*ִ�С��������ֻ����@code Runnable��@code execute�����ύ������

					@Override
					public Thread newThread(Runnable r) {

						System.out.println("�½��߳�");
						return null;
					}
				}, new ThreadPoolExecutor.DiscardOldestPolicy()); // ��������ʱʹ�õĴ��������Ϊ�̱߽߳�Ͷ��������Ѿ��ﵽ

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
