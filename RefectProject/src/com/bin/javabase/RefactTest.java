package com.bin.javabase;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RefactTest {
	public static void main(String[] args) {
		try {
			Class<People> classInstance = People.class;
			
			
			/*//ͨ��������ƹ���ʵ��������Ĭ�ϵ����޲ι���
			People people = classInstance.newInstance();*/
			
			//ͨ��������ƹ���ʵ�������ǵ���ָ�����췽��
			Constructor<People> constructor = classInstance.getConstructor(new Class[] {long.class,String.class,int.class});
			People people = constructor.newInstance(new Object[] {517183,"�����",20});
			System.out.println("ʵ�����ɹ�");
			System.out.println(people.toString());
			System.out.println();
			
			printAllField();//��ӡPeople�����е��ֶ�
			printAllMethods();//��ӡPeople�����еķ���
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	
	}
	private static void printAllMethods() {
		Class<People> classInstance = People.class;
		System.out.println("��ӡPeople�����еķ���");
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
		System.out.println("��ӡPeople�����е��ֶ�");
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
