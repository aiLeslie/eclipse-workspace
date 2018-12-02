package cn.bin.javabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyAndCut {

	
	public static void copyFile(File sourceFile,File objectFile) throws IOException {
		InputStream inputStream = new FileInputStream(sourceFile);
		OutputStream outputStream = new FileOutputStream(objectFile,false);
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		outputStream.write(bytes);
		outputStream.close();
		inputStream.close();
	}

	public static void copyFile(String sourceName,String objectName) throws IOException {
		InputStream inputStream = new FileInputStream(sourceName);
		OutputStream outputStream = new FileOutputStream(objectName,false);
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		outputStream.write(bytes);
		outputStream.close();
		inputStream.close();
	}
	
	public static void cutFile(File sourceFile,File objectFile) throws IOException {
		InputStream inputStream = new FileInputStream(sourceFile);
		OutputStream outputStream = new FileOutputStream(objectFile,false);
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		outputStream.write(bytes);
		sourceFile.delete();
		outputStream.close();
		inputStream.close();
	}

	public static void cutFile(String sourceName,String objectName) throws IOException {
		InputStream inputStream = new FileInputStream(sourceName);
		OutputStream outputStream = new FileOutputStream(objectName,false);
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		outputStream.write(bytes);
		outputStream.close();
		inputStream.close();
	}

}
