package com.bin.javabase.collectionDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * �Ƚ����߹���Ч��
* ��Ŀ���ƣ�CollectionDemo   
* �����ƣ�ArrayListAndLinkedList   
* ��������
* �����ˣ������   
* ����ʱ�䣺2017��11��17�� ����11:42:10   
* @version 1.0
 */
public class ArrayListAndLinkedList {
	public  static final int count = 10000;

	public ArrayListAndLinkedList() {
		
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("ArrayList��ʱ:" + costTime(new ArrayList<>()) + "����");
		
		System.out.println("LinkedList��ʱ:" + costTime(new LinkedList<>()) + "����");
				 
	}
	public static long costTime(List<Object> list) {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < count;i++ ) {
//			list.add(0,i);
			list.add(i);
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

}
