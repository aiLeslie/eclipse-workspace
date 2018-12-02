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
		//读取文件的基本操作
		byte[] bytes = new byte[2000];
		/**
		 * 读取方法(本质是一样)
		 */
		inputStream.read(bytes);//第一种写法
//		while((bytes[count] = (byte)inputStream.read()) != -1 ) {
//			count++;
//		}//第二种写法
		
		String concent = new String(bytes);
		System.out.println(concent);
		inputStream.close();
	}
		
	
}
