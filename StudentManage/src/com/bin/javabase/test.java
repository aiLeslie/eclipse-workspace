package com.bin.javabase;

public class test {


	public static void main(String[] args) {
//		Students.sign(new Students("�����", 123, "male", "123"));

//		Students.loadData();
		//Students.clearData();
//		for(int i = 0; i < 1000; i++) {//����һǧ��ѧ����������
//			new Students(i + "", i, "feamale", 1559 - i +"");
//		}
		/**
		 * ʹ��foreach����list����ӡѧ����Ϣ
		 */
		Students.list.forEach(student -> System.out.println(student.getName() + "\t"
		+ student.getName() + "\t" + student.getName()));
		
		
		//Students.saveData();
		
		
	
	}

}
