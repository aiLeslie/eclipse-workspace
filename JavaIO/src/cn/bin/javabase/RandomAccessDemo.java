package cn.bin.javabase;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * 
* 项目名称：Stream   
* 类名称：RandomAccessDemo   
* 类描述：演示RandomAccess类的使用
* 创建人：李玮斌   
* 创建时间：2017年11月4日 上午11:11:11   
* @version 1.0
 */
public class RandomAccessDemo {
	private static final String filePath = "src/cn/bin/javabase/read.txt";
	private static final String copyPath = "src/cn/bin/javabase/readCopy.txt";

	public RandomAccessDemo() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		copyFile(filePath,copyPath);
//		try(RandomAccessFile accessFile = new RandomAccessFile(new File(filePath), "rw") ){
//			//读取文件内容
//			accessFile.setLength(0);//强制让文件大小归零 - 相当于删除文件中的所有内容
//			//写入2000个整型数据
//			
//			for(int i= 0;i < 2000;i++) {
//				accessFile.writeInt(i);
//			}
//			System.out.println("当前文件大小:" + accessFile.length() +"字节");
//			
//			//移动文件指针
//			accessFile.seek(7996);
//			System.out.println("赋值已把字符值与文件指针一致");
//			System.out.println("读第1999个字符" + accessFile.readInt());
//			//我:读完字符后文件指针自增1
//			System.out.println("得到当前文件指针" + accessFile.getFilePointer());
//			
//			accessFile.seek(4 * 800);
//			accessFile.writeInt(0);
//			accessFile.seek(4 * 800);
//			System.out.println("移动800个整形空间值为" + accessFile.readInt());
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	public static void copyFile(String resPath,String objPath) {
		try(RandomAccessFile src = new RandomAccessFile(new File(resPath), "r");
				RandomAccessFile obj = new RandomAccessFile(new File(objPath), "rw")
			){
			byte[] content = new byte[(int)src.length()];
			src.readFully(content);
			System.out.println("读入成功");
			System.out.println(new String(content));
			obj.write(content);
			System.out.println("写入成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
