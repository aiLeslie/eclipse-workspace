package com.bin.javabase;

public class Buffer {
	public static void main(String[]args) {
		StringBuffer str = new StringBuffer("Hello World!");
//		System.out.println("Hello World!".hashCode() == str.hashCode());
//		System.out.println(str.toString().hashCode() == str.hashCode());
//		System.out.println(str.hashCode());
		StringBuffer str2 = new StringBuffer("Hello World!");
		StringBuffer str3 = new StringBuffer("Hello World!");
		/**
		 * StringBuffer�Ĳ��빦��
		 */
		str.insert(0, "Leslie~~");
		System.out.println(str);
		/**
		 * StringBuffer��ɾ������
		 */
		str.delete(0, 6);//ɾ���±��start��end-1//ɾ������Ϊ����ҿ�����
		System.out.println(str.toString());
		/**
		 * StringBuffer�ĵ�����
		 */
		str2.reverse();
		System.out.println(str2);
		/**
		 * StringBuffer���滻����
		 */
		str2.replace(0, 12, "Hello World!");
		System.out.println(str2);
		
		str3.setCharAt(11, '~');
		System.out.println(str3);
		
		System.out.println("��Խ����\t\t��ռ�ڴ�Ϊ" + "��Խ����".length() + "�ֽ�");
		System.out.println("cunyueliqi\t��ռ�ڴ�Ϊ" + "cunyueliqi".length() + "�ֽ�");
		
		System.out.println("StringBuffer��str�����СΪ" + str.capacity());//
		
		
		
		
		
	}
}
