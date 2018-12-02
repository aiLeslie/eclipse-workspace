package com.leslie.javabase;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
	public static void main(String[] args) {
		// �����ַ�������
		String str = new String("PhantomReferenceTest");
		// �������ö���
		ReferenceQueue<String> queue = new ReferenceQueue<>();
		// ����������
		PhantomReference<String> reference = new PhantomReference<String>(str, queue);
		// �ж�str���ú��ַ��������֮�������
		str = null;
		// ��ͼȡ�������������ö���
		System.out.println(reference.get()); // ������ͨ�������÷��ʶ���,�����������null
		// �����������ջ���
		System.gc();
		System.runFinalization();
		// ȡ�����ö��������Ƚ�������е�������reference��Ƚ�
		System.out.println(queue.poll() == reference);
		
		
	}
}
