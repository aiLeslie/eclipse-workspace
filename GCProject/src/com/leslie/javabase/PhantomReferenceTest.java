package com.leslie.javabase;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
	public static void main(String[] args) {
		// 创建字符串对象
		String str = new String("PhantomReferenceTest");
		// 创建引用队列
		ReferenceQueue<String> queue = new ReferenceQueue<>();
		// 创建虚引用
		PhantomReference<String> reference = new PhantomReference<String>(str, queue);
		// 切断str引用和字符串对象的之间的引用
		str = null;
		// 试图取出虚引用所引用对象
		System.out.println(reference.get()); // 程序不能通过虚引用访问对象,所以这里输出null
		// 运行垃圾回收机制
		System.gc();
		System.runFinalization();
		// 取出引用队列中最先进入队列中的引用与reference相比较
		System.out.println(queue.poll() == reference);
		
		
	}
}
