package com.leslie.javabase;

import java.lang.ref.SoftReference;

/**
 * 
 * ��Ŀ���ƣ�GCProject �����ƣ�SoftReferenceTest ����������������ϰ �����ˣ������ ����ʱ�䣺2018��7��7��
 * ����11:20:20
 * 
 * @version 1.0
 */
// ��������: ǿ���� ������ ������ ������
public class SoftReferenceTest {
	

	public static void main(String[] args) {

		@SuppressWarnings("unchecked")
		SoftReference<Person>[] people = new SoftReference[10000000];
		for (int i = 0; i < people.length; i++) {
			people[i] = new SoftReference<Person>(new Person("name" + i, i * 4 % 100));
		}
		System.out.println(people[0].get());
		System.out.println(people[1].get());

		// ֪ͨϵͳ������������
		System.gc();
		System.runFinalization();
		// �������ջ�������֮��
		System.out.println(people[2].get());
		System.out.println(people[5].get());

		/**
		 * ǿ����: �����ڴ��Ƿ����,�������ջ�������ʱ,��������ǿ���õĶ��� 
		 * ������:��������ڴ����ʱ,��ʹ�����������ջ��ƶ���Ҳ���ᱻ����,Ч����ǿ����һ����������ڴ����ʱ,�������ջ�������������õĶ��� 
		 * ������ :���������е�����,�������������ڸ���,�����ڴ��Ƿ����,�������ջ��ƶ����ܻ����������õĶ���
		 * ������: ��Ҫ����ʹ��,������ö���ʹ��,�����������������ʶ���
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
