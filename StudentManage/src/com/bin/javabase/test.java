package com.bin.javabase;

public class test {


	public static void main(String[] args) {
//		Students.sign(new Students("李玮斌", 123, "male", "123"));

//		Students.loadData();
		//Students.clearData();
//		for(int i = 0; i < 1000; i++) {//创建一千个学生对象试验
//			new Students(i + "", i, "feamale", 1559 - i +"");
//		}
		/**
		 * 使用foreach遍历list并打印学生消息
		 */
		Students.list.forEach(student -> System.out.println(student.getName() + "\t"
		+ student.getName() + "\t" + student.getName()));
		
		
		//Students.saveData();
		
		
	
	}

}
