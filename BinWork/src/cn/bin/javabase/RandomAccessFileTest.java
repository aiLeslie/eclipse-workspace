package cn.bin.javabase;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException {
		
		File file = new File("./raf.txt");
		if (!file.exists())file.createNewFile();
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
//		raf.writeInt(10);
		raf.seek(0);
		int value = raf.readInt();
		System.out.println(value);
		raf.close();
		
		
		
		
	}
}
