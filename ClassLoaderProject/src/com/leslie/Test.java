package com.leslie;

public class Test {
	
	public static void main(String[] args) throws Exception {
		Class<Person> classType = Person.class;
		// ���������ʹ��MyAnnotation��ע��
		if (classType.isAnnotationPresent(MyAnnotation.class)) {
			
			System.out.println("���ע�����");
			MyAnnotation annotation = classType.getAnnotation(MyAnnotation.class);
			
			System.out.println(annotation.value());
		} else {
			System.err.println("������û��ʹ��MyAnnotation��ע��");
		}
		
	
	}

}

@MyAnnotation("TYPE")	
 class Person{
	 
	public String name;
	
}
