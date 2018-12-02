package cn.bin.javabase.chapter0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.bin.javabase.chapter0.Hello.Hi;

public class HelloTest {
	public static void main(String[] args) {
		

		Hello.Hi hi = new Hello.Hi() {

			@Override
			public void printHello() {
				System.out.println("hi,world!");

			}
		};
		System.out.print("�õ�Hello.Hi class����:");
		Class<?> classType = hi.getClass();
		System.out.println(classType.toString());
		System.out.print(Hello.Hi.class + "�Ƚ�getClass�����뾲̬����forName�õ�ʵ����ͬһ����?");
		try {
			Class<?> temp = Class.forName("cn.bin.javabase.chapter0.Hello$Hi");
			System.out.println(temp.toString());
			System.out.println(classType.equals(temp));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		System.out.println("�������ǽӿ���? " + classType.isInterface());

		try {
			hi = (Hi) classType.newInstance();
			Method m = classType.getDeclaredMethod("printHello");
			System.out.println("������:" + m.getName() + "\nִ�з���:");
			m.invoke(hi, new Object[0]);

		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
