package cn.bin.javabase;

import java.io.File;
/**
 * 
* 项目名称：Stream   
* 类名称：MyFile   
* 类描述：文件类使用练习
* 创建人：李玮斌   
* 创建时间：2017年10月15日 下午2:56:03   
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
