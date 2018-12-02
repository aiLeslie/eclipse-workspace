package cn.bin.javabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileUtils {
	private static final int BUFFER_SIZE = 1024 * 8;

	public static boolean copy(String originPath, String objPath) {
		return copy(new File(originPath), new File(objPath));
	}

	public static boolean copy(File origin, File obj) {
		if (obj.getAbsolutePath().contains(origin.getAbsolutePath())) {
			return false;
		}
		
		if (!origin.exists())
			return false;

		if (origin.isDirectory()) {
			return CopyFolder(origin, obj);
		}

		return CopyFile(origin, obj);

	}

	private static boolean CopyFile(File origin, File obj) {
		RandomAccessFile oriRaf = null, objRaf = null;
		byte[] bytes = new byte[BUFFER_SIZE];
		int count = -1;
		try {
			oriRaf = new RandomAccessFile(origin, "r");

			objRaf = new RandomAccessFile(obj, "rw");

			while ((count = oriRaf.read(bytes, 0, BUFFER_SIZE)) != -1) {
				objRaf.write(bytes, 0, count);
			}

			return true;

		} catch (FileNotFoundException e) {
			System.out.println(origin.getAbsolutePath());
			System.out.println(obj.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oriRaf != null) {
				try {
					oriRaf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (objRaf != null) {
				try {
					objRaf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	private static boolean CopyFolder(File origin, File obj) {
		obj.mkdirs();

		File[] files = origin.listFiles();

		boolean isSuccess = true;

		for (File file : files) {

			if (file.isDirectory()) {
				CopyFolder(file, new File(getObjFilePath(file, obj)));
			}

			if (!copy(file, new File(getObjFilePath(file, obj)))) {
				isSuccess = false;
			}
		}

		return isSuccess;

	}

	private static String getObjFilePath(File origin, File obj) {

		return obj.getAbsolutePath() + "/" + origin.getName();

	}

	public static void main(String[] args) {
		if (FileUtils.copy("D:/Temp/1", "D:/Temp/2") ) {
			System.out.println("yes!");
		}
		

	}
}
