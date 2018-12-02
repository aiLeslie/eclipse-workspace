package com.bin.javabase.collectionDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

public class ArraylistDemo {

	public ArraylistDemo() {
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Collection<String> list = new ArrayList<>();
//		for(int i = 1;i < 10;i++) {
//			list.add(i + "");
//		}
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("src/com/bin/javabase/collectionDemo/obj.dat"));
			out.writeObject(list);
			System.out.println("д��ɹ�");
			in = new ObjectInputStream(new FileInputStream("src/com/bin/javabase/collectionDemo/obj.dat"));
			list = (ArrayList<String>)(in.readObject());
			System.out.println("����ɹ�");
			System.out.println(list);
			
			System.out.println("ʹ��foreach����list");
			for (String string : list) {
				
				System.out.print(string);
			}
			
			System.out.println("\nʹ��list�ĵ�����������б���");
			ListIterator<String> iterator = ((ArrayList<String>) list).listIterator(list.size());
			while(iterator.hasPrevious()) {
				System.out.print(iterator.previous() + " ");
			}
			

		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(in!= null)
				in.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try {
				if(out!= null)out.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
				
	}

}
