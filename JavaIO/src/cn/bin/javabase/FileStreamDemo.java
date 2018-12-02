package cn.bin.javabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamDemo {

	public static void main(String []args) throws IOException {
		final String filePath = "C:\\Users\\Administrator\\workspace\\Stream\\src\\cn\\bin\\javabase\\FileStreamDemo.java";
		final String filePath1  = "C:\\Users\\Administrator\\workspace\\Stream\\src\\cn\\bin\\javabase\\FileStreamDemo1.java";
		
		//writeFile();
		//readFile();
		CopyAndCut.copyFile(filePath, filePath1);
		//new File(filePath1).delete();
		
		
	}
	
	public static void writeFile() throws IOException {
		final String filePath1  = "C:\\Users\\Administrator\\workspace\\Stream\\src\\cn\\bin\\javabase\\FileStreamDemo1.java";
		OutputStream outStream = new FileOutputStream(filePath1);
		String concent =  "package cn.bin.javabase;\npublic class FileStreamDemo1{public static void main (String []args) {\n";
		concent = concent.concat("\tSystem.out.println(\"Hello World\");\n\t}\n}");
		outStream.write(concent.getBytes());
		outStream.close();
	}
	
	public static void readFile () throws IOException {
		final String filePath = "C:\\Users\\Administrator\\workspace\\Stream\\src\\cn\\bin\\javabase\\FileStreamDemo.java";
		File file = new File(filePath);
		InputStream inputStream = new FileInputStream(file);
		//��ȡ�ļ��Ļ�������
		byte[] bytes = new byte[2000];
		/**
		 * ��ȡ����(������һ��)
		 */
		inputStream.read(bytes);//��һ��д��
//		while((bytes[count] = (byte)inputStream.read()) != -1 ) {
//			count++;
//		}//�ڶ���д��
		
		String concent = new String(bytes);
		System.out.println(concent);
		inputStream.close();
	}
		
	
}
