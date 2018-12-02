package com.leslie.javabase;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceTest {
	public static void main(String[] args) {
		/**
		 * * ������  : ���������е�����,�������������ڸ���,�����ڴ��Ƿ����,�������ջ��ƶ����ܻ����������õĶ���
		 */
		System.out.println("������Test");
		WeakReference<String> wf = new WeakReference<String>(new String("Leslie"));
		System.out.println(wf.get());
		System.out.println("ǿ����������");
		System.gc();
		System.runFinalization();
		System.out.println(wf.get());
		
		
		
		System.out.println();
		/**
		 * ������: ��������ڴ����ʱ,��ʹ�����������ջ��ƶ���Ҳ���ᱻ����,Ч����ǿ����һ����������ڴ����ʱ,�������ջ�������������õĶ���
		 */
		System.out.println("������Test");
		SoftReference<String> sf = new SoftReference<String>(new String("�����"));
		System.out.println(sf.get());
		args = new String[(int)(1000000000 * 0.5)]; // ģ���ڴ����
		System.out.println("ǿ����������");
		System.gc();
		System.runFinalization();
		System.out.println(sf.get());
		
	}
}
