package com.bin.javabase;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RefactTest {
	public static void main(String[] args) {
		try {
			Class<People> classInstance = People.class;
			
			
			/*//通过反射机制构造实例对象是默认调用无参构造
			People people = classInstance.newInstance();*/
			
			//通过反射机制构造实例对象是调用指定构造方法
			Constructor<People> constructor = classInstance.getConstructor(new Class[] {long.class,String.class,int.class});
			People people = constructor.newInstance(new Object[] {517183,"李玮斌",20});
			System.out.println("实例化成功");
			System.out.println(people.toString());
			System.out.println();
			
			printAllField();//打印People类所有的字段
			printAllMethods();//打印People类所有的方法
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	
	}
	private static void printAllMethods() {
		Class<People> classInstance = People.class;
		System.out.println("打印People类所有的方法");
		for(java.lang.reflect.Method method: classInstance.getDeclaredMethods()) {
			for(int i = 0 ;i < 80 ;i++)
			System.out.print("~");
			System.out.println();
			System.out.println(method);
			System.out.println(method.getName());
			for(int i = 0 ;i < 80 ;i++)
				System.out.print("~");
		}
	}
	private static void printAllField() {
		Class<People> classInstance = People.class;
		System.out.println("打印People类所有的字段");
		for(java.lang.reflect.Field field: classInstance.getDeclaredFields()) {
			for(int i = 0 ;i < 80 ;i++)
			System.out.print("~");
			System.out.println();
			System.out.println(field);
			System.out.println(field.getName());
			for(int i = 0 ;i < 80 ;i++)
				System.out.print("~");
		}
	}
	public static class People {
		private long id;
		private String name;
		private int age;
		
		/*public People() {
			super();
		}*/
		public People(long id, String name, int age) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "[" + this.getId() + "~" + this.getName() + "~" + this.getAge() + "]";
		}
		
		

	}

}
