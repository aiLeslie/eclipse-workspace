package com.leslie.javabase;



public class Test {	
	// run config: -verbose:class -verbose:gc
	// jps����:  �鿴��������java����
	// jcmd����: ����java����
	public static void main(String[] args) {
		// �鿴�����ʵ������
		System.out.println("HelloWorld!");
		
		// ������������(c/c++ʵ��,���Բ���Java��������Ϊnull)
		System.out.println(Object.class.getClassLoader()); // Bootstrap������ 
		
		// �û������������
		System.out.println(Test.class.getClassLoader().getParent());
	}
	
	public void printMsg(String msg) {
		System.out.println("�ڶ����޸�");
		System.out.println(msg);
	}
}
