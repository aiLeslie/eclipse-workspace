package com.bin.javabase.test;

import java.util.concurrent.TimeUnit;

public class DaemonThreadDemo {

	
		public static void main(String[] args)
		{
			Thread mainThread = new Thread(new Runnable(){
				@Override
				public void run()
				{
					Thread childThread = new Thread(new ClildThread());
					childThread.setDaemon(false);
					childThread.start();
					System.out.println("I'm main thread...");
				}
			});
			mainThread.start();
		}
	}

	class ClildThread implements Runnable
	{
		@Override
		public void run()
		{
			while(true)
			{
				System.out.println("I'm child thread..");
				try
				{
					TimeUnit.MILLISECONDS.sleep(1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	
}
