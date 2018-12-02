package com.bin.javabase.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bin.javabase.bean.Person;

public class InsertAttrTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Person person = (Person)context.getBean("person");
		System.out.println(person);
	}
}
