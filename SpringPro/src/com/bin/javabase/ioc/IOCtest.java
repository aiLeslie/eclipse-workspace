package com.bin.javabase.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bin.javabase.bean.User;

/**
 * 
 * ��Ŀ���ƣ�SpringProject �����ƣ�IOCtest �������� �����ˣ������ ����ʱ�䣺2018��9��15�� ����11:23:24
 * 
 * @version 1.0
 */
public class IOCtest {
	/**
	 * 1. ����jar��(Beans Core Context Expression) ������־jar��2. ������,�������洴������
	 * 3.����spring�����ļ�,���ô����� (����schemaԼ��)4. д������Զ��󴴽�
	 */

	// 1.����spring�����ļ�,���ݴ�������
	private static ApplicationContext context;
	

	@Test
	/**
	 * 1. ֱ��ʹ����ʵ��������
	 */
	public static void userTest() {
		// 2.�õ����ö���
		User user = (User) context.getBean("user1");

		System.out.println(user.toString());

		user.add();

	}
	/**
	 * ʹ�þ�̬������������
	 */
	public static void useStaticFactory() {

		User user = (User) context.getBean("user2");

		System.out.println(user.toString());

		user.add();
	}
	
	/**
	 * ʹ�ù���ʵ����������
	 */
	public static void useInstanceFactory() {

		User user = (User) context.getBean("user3");

		System.out.println(user.toString());

		user.add();
	}

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		userTest();

		useStaticFactory();
		
		useInstanceFactory();
	}

}
