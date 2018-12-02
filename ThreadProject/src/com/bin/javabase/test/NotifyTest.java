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
        	System.out.println(Thread.currentThread().getName() + "唤醒在同个对象监视器的一个等待线程");
            test.notify();
        }
        
        //test.notify();错误的做法
        
        
        Thread.sleep(3000);
        
        System.out.println("-----------分割线-------------");
        
        synchronized (test) {
        	System.out.println(Thread.currentThread().getName() + "唤醒在同个对象监视器的全部等待线程");
            test.notifyAll();
        }
        
        //test.notifyAll();错误的做法
    }
}
