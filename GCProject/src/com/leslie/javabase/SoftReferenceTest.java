package com.leslie.javabase;

import java.lang.ref.SoftReference;

/**
 * 
 * 项目名称：GCProject 类名称：SoftReferenceTest 类描述：软引用练习 创建人：李玮斌 创建时间：2018年7月7日
 * 下午11:20:20
 * 
 * @version 1.0
 */
// 引用种类: 强引用 软引用 弱引用 虚引用
public class SoftReferenceTest {
	

	public static void main(String[] args) {

		@SuppressWarnings("unchecked")
		SoftReference<Person>[] people = new SoftReference[10000000];
		for (int i = 0; i < people.length; i++) {
			people[i] = new SoftReference<Person>(new Person("name" + i, i * 4 % 100));
		}
		System.out.println(people[0].get());
		System.out.println(people[1].get());

		// 通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		// 垃圾回收机制运行之后
		System.out.println(people[2].get());
		System.out.println(people[5].get());

		/**
		 * 强引用: 无论内存是否紧张,垃圾回收机制运行时,不会清理强引用的对象 
		 * 软引用:在虚拟机内存充足时,即使运行垃圾回收机制对象也不会被回收,效果和强引用一样在虚拟机内存紧张时,垃圾回收机将会回收软引用的对象 
		 * 弱引用 :与软引用有点相似,区别在于生命期更短,无论内存是否紧张,垃圾回收机制对象总会清理弱引用的对象
		 * 虚引用: 不要单独使用,配合引用队列使用,不能用虚引用来访问对象
		 */
	}
}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name = " + name + ", age = " + age + "]";
	}
}
