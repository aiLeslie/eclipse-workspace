package com.bin.javabase.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Person {
	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {

		return "My name is " + name + "," + age + " years old.";
	}
	/**
	 * ◊¢»Î Ù–‘
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Person person = (Person) context.getBean("person");
		System.out.println(person);
	}

}
