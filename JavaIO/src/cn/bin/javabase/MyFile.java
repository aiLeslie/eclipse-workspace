package cn.bin.javabase;

import java.io.File;
/**
 * 
* ��Ŀ���ƣ�Stream   
* �����ƣ�MyFile   
* ���������ļ���ʹ����ϰ
* �����ˣ������   
* ����ʱ�䣺2017��10��15�� ����2:56:03   
* @version 1.0
 */
public class MyFile {

	public MyFile() {
		
	}
	public static void main(String []args) {
		String filePath = ".";
		
		File file = new File(filePath);
		System.out.println(file.exists());
		System.out.println(file);
	}

}
