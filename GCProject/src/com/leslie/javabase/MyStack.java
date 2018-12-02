package com.leslie.javabase;

import java.util.Arrays;

public class MyStack {
	private static Object[] EMPTY_STACk = new Object[0];
	private Object[] elementData;
	private int capacity = 0;
	private int capacityIncrement = 16;
	private int size = 0;
	// Ĭ�Ϲ�����
	public MyStack() {
		elementData = EMPTY_STACk;
	}
	// ָ����ʼ�����Ĺ�����
	public MyStack(int capacity) {
		// ���������ٲ�������,�׳��쳣
		if (capacity <= 0)
			throw new IllegalArgumentException();
		// ��ʼ������������
		this.capacity = capacity;
		elementData = new Object[capacity];
	}

	// ��ջ���ƽ�Ԫ�� (��ջ)
	public void push(Object obj) {
		/**
		 * �ߴ�����1�������� 
		 * �����Ӵ� 
		 * ����䳤
		 */
		if (++size > capacity) {
			capacity += capacityIncrement;
			elementData = Arrays.copyOf(elementData, capacity);
		} 
			elementData[size - 1] = obj;
		
	}

	/**
	 *  ɾ��ջβԪ�ز����� (��ջ)
	 * @return
	 */
	public Object pop() {
		// �ߴ�Ϊ0����null
		if (size == 0) return null;
		Object obj = elementData[--size];
		// ��ֹ�ڴ�й¶
		elementData[size] = null;
		return obj;
	
	}
	/**
	 *  ����ջ��Ԫ������
	 * @return
	 */
	public MyStack trim() {
		capacity = size;
		elementData = Arrays.copyOf(elementData, size);
		return this;
	}
	/**
	 *  ���ջ��Ԫ��
	 */
	public MyStack clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
		return this;
	}
	/**
	 * ��ӡջ������Ԫ��
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
