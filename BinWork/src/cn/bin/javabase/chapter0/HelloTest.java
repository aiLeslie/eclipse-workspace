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
		System.out.print("得到Hello.Hi class类型:");
		Class<?> classType = hi.getClass();
		System.out.println(classType.toString());
		System.out.print(Hello.Hi.class + "比较getClass方法与静态方法forName得到实例是同一个吗?");
		try {
			Class<?> temp = Class.forName("cn.bin.javabase.chapter0.Hello$Hi");
			System.out.println(temp.toString());
			System.out.println(classType.equals(temp));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		System.out.println("该类型是接口吗? " + classType.isInterface());

		try {
			hi = (Hi) classType.newInstance();
			Method m = classType.getDeclaredMethod("printHello");
			System.out.println("方法名:" + m.getName() + "\n执行方法:");
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
