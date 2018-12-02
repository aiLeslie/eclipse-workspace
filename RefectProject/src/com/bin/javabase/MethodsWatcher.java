package com.bin.javabase;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MethodsWatcher {
	public static void main(String[] args) throws Exception {
//		watchMethods(String.class);
//		String.copyValueOf(data, offset, count)
//		Method method = String.class.getDeclaredMethod("copyValueOf", new Class[] {char[].class, int.class, int.class});
//		String invoke = (String) method.invoke(String.class, new Object[] {new char[] {'a', 'b', 'c'}, 0,1});
//		System.out.println(invoke);
		
		System.out.println(new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		}.getClass());
		
		System.out.println(new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		}.getClass());
		
	}
	
	
	public static void watchMethods(Class<?> classType) {
		
		System.out.println(classType.getName());
		System.out.println();
		for (Method m : classType.getMethods()) {
			System.out.print(m.getName());
			System.out.print("\t");
			System.out.print("(");
			for (Parameter p : m.getParameters()) {
				System.out.print(p.getType() +", ");
			} 
			System.out.print(")");
			System.out.println();
		}
	}
	
	
}
