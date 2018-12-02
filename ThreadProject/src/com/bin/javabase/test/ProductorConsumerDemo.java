package com.bin.javabase.test;

import java.util.Deque;
import java.util.LinkedList;

public class ProductorConsumerDemo {

	public static void main(String[] args) {
		Basket basket = new Basket();
		new Productor(basket).start();
		new Consumer(basket).start();	
		
	}

}
class Productor extends Thread{
	Basket basket;
	public Productor(Basket basket) {
		if(basket == null)throw new NullPointerException("NullPointerException");
		this.basket = basket;
	}
		public void run() {
			basket.push();
		}
	
}
class Consumer extends Thread{
	Basket basket;
	public Consumer(Basket basket) {
		if(basket == null)throw new NullPointerException("NullPointerException");
		this.basket = basket;
	}
		public void run() {
			basket.pop();
		}
	
}
class Basket{
	private  Deque<Apple> basket = new LinkedList<>();
	private  void pushApple(Apple apple)  {
		//当篮子当中存放了5个苹果就等待并通知
		if(basket.size() == 5) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//并释放当前对象的锁
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		basket.push(apple);
		System.out.println("Productor在篮子放入" + apple.toString());
		notify();
		
	}
	private void takeOutApple() {
		//当篮子当中存放了5个苹果就等待并通知
		if(basket.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//并释放当前对象的锁
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Apple apple = basket.pop();
		System.out.println("Consumer从篮子拿出" + apple.toString());
		notify();
		
	}
	public synchronized void pop() {
		for(int i = 0; i < 20 ;i++) {
			takeOutApple();
		}
	}
	public synchronized void push() {
		for(int i = 0; i < 20 ;i++) {
			pushApple(new Apple(i));
		}
	}
}
class Apple{
	private int id;
	public Apple(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "苹果~" + (id + 1);
	}
}