package com.bin.javabase.test;



public class NotifyTest {
    public synchronized void testWait(){
        System.out.println(Thread.currentThread().getName() +" Start-----");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" End-------");
    }

    public static void main(String[] args) throws InterruptedException {
        final NotifyTest test = new NotifyTest();
        for(int i=0;i<5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.testWait();
                }
            }).start();
        }
        
        synchronized (test) {
        	System.out.println(Thread.currentThread().getName() + "������ͬ�������������һ���ȴ��߳�");
            test.notify();
        }
        
        //test.notify();���������
        
        
        Thread.sleep(3000);
        
        System.out.println("-----------�ָ���-------------");
        
        synchronized (test) {
        	System.out.println(Thread.currentThread().getName() + "������ͬ�������������ȫ���ȴ��߳�");
            test.notifyAll();
        }
        
        //test.notifyAll();���������
    }
}
