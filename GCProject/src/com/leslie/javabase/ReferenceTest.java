package com.leslie.javabase;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceTest {
	public static void main(String[] args) {
		/**
		 * * 弱引用  : 与软引用有点相似,区别在于生命期更短,无论内存是否紧张,垃圾回收机制对象总会清理弱引用的对象
		 */
		System.out.println("弱引用Test");
		WeakReference<String> wf = new WeakReference<String>(new String("Leslie"));
		System.out.println(wf.get());
		System.out.println("强制垃圾回收");
		System.gc();
		System.runFinalization();
		System.out.println(wf.get());
		
		
		
		System.out.println();
		/**
		 * 软引用: 在虚拟机内存充足时,即使运行垃圾回收机制对象也不会被回收,效果和强引用一样在虚拟机内存紧张时,垃圾回收机将会回收软引用的对象
		 */
		System.out.println("软引用Test");
		SoftReference<String> sf = new SoftReference<String>(new String("李玮斌"));
		System.out.println(sf.get());
		args = new String[(int)(1000000000 * 0.5)]; // 模拟内存紧张
		System.out.println("强制垃圾回收");
		System.gc();
		System.runFinalization();
		System.out.println(sf.get());
		
	}
}
