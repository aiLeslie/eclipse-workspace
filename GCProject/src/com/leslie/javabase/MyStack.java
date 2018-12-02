package com.leslie.javabase;

import java.util.Arrays;

public class MyStack {
	private static Object[] EMPTY_STACk = new Object[0];
	private Object[] elementData;
	private int capacity = 0;
	private int capacityIncrement = 16;
	private int size = 0;
	// 默认构造器
	public MyStack() {
		elementData = EMPTY_STACk;
	}
	// 指定初始容量的构造器
	public MyStack(int capacity) {
		// 传进参数少不大于零,抛出异常
		if (capacity <= 0)
			throw new IllegalArgumentException();
		// 初始化容量和数组
		this.capacity = capacity;
		elementData = new Object[capacity];
	}

	// 向栈内推进元素 (入栈)
	public void push(Object obj) {
		/**
		 * 尺寸增加1大于容量 
		 * 容量加大 
		 * 数组变长
		 */
		if (++size > capacity) {
			capacity += capacityIncrement;
			elementData = Arrays.copyOf(elementData, capacity);
		} 
			elementData[size - 1] = obj;
		
	}

	/**
	 *  删除栈尾元素并返回 (出栈)
	 * @return
	 */
	public Object pop() {
		// 尺寸为0返回null
		if (size == 0) return null;
		Object obj = elementData[--size];
		// 防止内存泄露
		elementData[size] = null;
		return obj;
	
	}
	/**
	 *  整理栈内元素容量
	 * @return
	 */
	public MyStack trim() {
		capacity = size;
		elementData = Arrays.copyOf(elementData, size);
		return this;
	}
	/**
	 *  清空栈内元素
	 */
	public MyStack clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
		return this;
	}
	/**
	 * 打印栈内所有元素
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("stack [");
		if (size > 0) {
			for (Object o : elementData) {
				buffer.append(o);
				buffer.append(",");
			}
		}
		
		buffer.append("]");
		return buffer.toString();
		
	}

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		for (int i = 0; i < 9; i++) {
			myStack.push(i);
		}
		for (int i = 0; i < 2; i++) {
			System.out.println(myStack.pop());
		}
		System.out.println(myStack.trim().clear());
	}
}
