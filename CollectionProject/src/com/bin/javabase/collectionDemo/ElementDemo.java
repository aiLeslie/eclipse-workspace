package com.bin.javabase.collectionDemo;

import java.io.Serializable;
/**
 * ��ⷺ�ͻ�������
* ��Ŀ���ƣ�CollectionDemo   
* �����ƣ�ElementDemo   
* ��������
* �����ˣ������   
* ����ʱ�䣺2017��11��17�� ����12:23:47   
* @version 1.0
 */
public class ElementDemo<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ElementDemo() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Object []objs = new Object[5];
		objs[0] = Integer.valueOf("1").intValue();
		objs[1] = "1024";
		objs[2] = "hello";
		objs[3] = 19.9;
		objs[4] = 2;
		for (Object object : objs) {
			System.out.println(object);
		}
		
		
	}
	public  void add(E[] e) {
		
	}
}
