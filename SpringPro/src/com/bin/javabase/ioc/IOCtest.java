package com.bin.javabase.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bin.javabase.bean.User;

/**
 * 
 * 项目名称：SpringProject 类名称：IOCtest 类描述： 创建人：李玮斌 创建时间：2018年9月15日 下午11:23:24
 * 
 * @version 1.0
 */
public class IOCtest {
	/**
	 * 1. 导入jar包(Beans Core Context Expression) 导入日志jar包2. 创建类,在类里面创建方法
	 * 3.创建spring配置文件,配置创建类 (引入schema约束)4. 写代码测试对象创建
	 */

	// 1.加载spring配置文件,根据创建对象
	private static ApplicationContext context;
	

	@Test
	/**
	 * 1. 直接使用类实例化对象
	 */
	public static void userTest() {
		// 2.得到配置对象
		User user = (User) context.getBean("user1");

		System.out.println(user.toString());

		user.add();

	}
	/**
	 * 使用静态工厂创建对象
	 */
	public static void useStaticFactory() {

		User user = (User) context.getBean("user2");

		System.out.println(user.toString());

		user.add();
	}
	
	/**
	 * 使用工厂实例创建对象
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
