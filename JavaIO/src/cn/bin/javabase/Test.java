package cn.bin.javabase;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/cn/bin/javabase/read.txt")) ;){
			
			byte [] content = new byte[13];
			try {
				System.out.println(in.read(content));
				System.out.println(new String(content));
				
				System.out.println(in.read(content));
				System.out.println(new String(content));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
