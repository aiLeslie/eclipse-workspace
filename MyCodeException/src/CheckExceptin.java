import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 必检异常 - 除了RunTimeException/Error的其他类异常
 * 
 * @author Administrator
 *
 */
public class CheckExceptin {

	public CheckExceptin() {
	}

	public static void main(String[] args) throws IOException {
		File file = new File("c:/test.txt");
		/* try{ */FileWriter writer = new FileWriter(file);// 文件写入器,用来将内容写入到文件中
		/*
		 * }catch(Exception exception) { System.out.println(exception.getMessage()); }
		 */
		// 判断这个文件是否存在
		System.out.println(file.exists());
		writer.close();
	}

}
