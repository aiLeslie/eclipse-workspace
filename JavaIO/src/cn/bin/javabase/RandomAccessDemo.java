package cn.bin.javabase;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * 
* ��Ŀ���ƣ�Stream   
* �����ƣ�RandomAccessDemo   
* ����������ʾRandomAccess���ʹ��
* �����ˣ������   
* ����ʱ�䣺2017��11��4�� ����11:11:11   
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
//			//��ȡ�ļ�����
//			accessFile.setLength(0);//ǿ�����ļ���С���� - �൱��ɾ���ļ��е���������
//			//д��2000����������
//			
//			for(int i= 0;i < 2000;i++) {
//				accessFile.writeInt(i);
//			}
//			System.out.println("��ǰ�ļ���С:" + accessFile.length() +"�ֽ�");
//			
//			//�ƶ��ļ�ָ��
//			accessFile.seek(7996);
//			System.out.println("��ֵ�Ѱ��ַ�ֵ���ļ�ָ��һ��");
//			System.out.println("����1999���ַ�" + accessFile.readInt());
//			//��:�����ַ����ļ�ָ������1
//			System.out.println("�õ���ǰ�ļ�ָ��" + accessFile.getFilePointer());
//			
//			accessFile.seek(4 * 800);
//			accessFile.writeInt(0);
//			accessFile.seek(4 * 800);
//			System.out.println("�ƶ�800�����οռ�ֵΪ" + accessFile.readInt());
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
			System.out.println("����ɹ�");
			System.out.println(new String(content));
			obj.write(content);
			System.out.println("д��ɹ�");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
