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
		 * StringBuffer的插入功能
		 */
		str.insert(0, "Leslie~~");
		System.out.println(str);
		/**
		 * StringBuffer的删除功能
		 */
		str.delete(0, 6);//删除下标从start到end-1//删除区间为左闭右开区间
		System.out.println(str.toString());
		/**
		 * StringBuffer的倒序功能
		 */
		str2.reverse();
		System.out.println(str2);
		/**
		 * StringBuffer的替换功能
		 */
		str2.replace(0, 12, "Hello World!");
		System.out.println(str2);
		
		str3.setCharAt(11, '~');
		System.out.println(str3);
		
		System.out.println("村越理奇\t\t所占内存为" + "村越理奇".length() + "字节");
		System.out.println("cunyueliqi\t所占内存为" + "cunyueliqi".length() + "字节");
		
		System.out.println("StringBuffer的str缓存大小为" + str.capacity());//
		
		
		
		
		
	}
}
