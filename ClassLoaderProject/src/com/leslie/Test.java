package com.leslie;

public class Test {
	
	public static void main(String[] args) throws Exception {
		Class<Person> classType = Person.class;
		// 如果该类有使用MyAnnotation的注解
		if (classType.isAnnotationPresent(MyAnnotation.class)) {
			
			System.out.println("获得注解对象");
			MyAnnotation annotation = classType.getAnnotation(MyAnnotation.class);
			
			System.out.println(annotation.value());
		} else {
			System.err.println("该类型没有使用MyAnnotation的注解");
		}
		
	
	}

}

@MyAnnotation("TYPE")	
 class Person{
	 
	public String name;
	
}
