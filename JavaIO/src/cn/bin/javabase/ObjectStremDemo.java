package cn.bin.javabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
* 项目名称：Stream   
* 类名称：ObjectStremDemo   
* 类描述：对象序列化操作
* 前提:对象必须实现Serializable接口(序列接口)
* 创建人：李玮斌   
* 创建时间：2017年10月29日 下午12:38:51   
* @version 1.0
 */
public class ObjectStremDemo {
	private static final String filePath = "src/cn/bin/javabase/objInfo.dat";
	public ObjectStremDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		System.out.println("写入操作");
		Player player = new Player("我的世界你不懂", 99);
		try(
				FileOutputStream foutputStream = new FileOutputStream(new File(filePath));
				//使用对象流序列化的对象写入到文件中
				ObjectOutputStream objOutputStream = new ObjectOutputStream(foutputStream);
				){
			objOutputStream.writeObject(player);
			System.out.println("对象流写入成功");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n读入操作");
				
		try(FileInputStream fileInputStream = new FileInputStream(filePath);
				ObjectInputStream objinputStream = new ObjectInputStream(fileInputStream);
						 ){
			Player player2 = (Player)objinputStream.readObject() ;
			System.out.println(player2);
			System.out.println("对象地址比较:" + (player2 == player));
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

