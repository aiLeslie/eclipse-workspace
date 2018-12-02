package cn.bin.javabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
* ��Ŀ���ƣ�Stream   
* �����ƣ�ObjectStremDemo   
* ���������������л�����
* ǰ��:�������ʵ��Serializable�ӿ�(���нӿ�)
* �����ˣ������   
* ����ʱ�䣺2017��10��29�� ����12:38:51   
* @version 1.0
 */
public class ObjectStremDemo {
	private static final String filePath = "src/cn/bin/javabase/objInfo.dat";
	public ObjectStremDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		System.out.println("д�����");
		Player player = new Player("�ҵ������㲻��", 99);
		try(
				FileOutputStream foutputStream = new FileOutputStream(new File(filePath));
				//ʹ�ö��������л��Ķ���д�뵽�ļ���
				ObjectOutputStream objOutputStream = new ObjectOutputStream(foutputStream);
				){
			objOutputStream.writeObject(player);
			System.out.println("������д��ɹ�");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n�������");
				
		try(FileInputStream fileInputStream = new FileInputStream(filePath);
				ObjectInputStream objinputStream = new ObjectInputStream(fileInputStream);
						 ){
			Player player2 = (Player)objinputStream.readObject() ;
			System.out.println(player2);
			System.out.println("�����ַ�Ƚ�:" + (player2 == player));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	static class Player implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private String nickName;
		private int level;
		public Player(){
			
		}
		public Player (String nickName , int level) {
			setNickName(nickName);
			setLevel(level);
		}
		
		@Override
		public String toString() {
			return nickName + "\t" + level;
		}
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		
	}
}

