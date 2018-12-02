package com.bin.javabase.collectionDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 比较两者工作效率
* 项目名称：CollectionDemo   
* 类名称：ArrayListAndLinkedList   
* 类描述：
* 创建人：李玮斌   
* 创建时间：2017年11月17日 上午11:42:10   
* @version 1.0
 */
public class ArrayListAndLinkedList {
	public  static final int count = 10000;

	public ArrayListAndLinkedList() {
		
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("ArrayList用时:" + costTime(new ArrayList<>()) + "毫秒");
		
		System.out.println("LinkedList用时:" + costTime(new LinkedList<>()) + "毫秒");
				 
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
