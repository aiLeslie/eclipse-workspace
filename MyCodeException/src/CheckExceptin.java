import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �ؼ��쳣 - ����RunTimeException/Error���������쳣
 * 
 * @author Administrator
 *
 */
public class CheckExceptin {

	public CheckExceptin() {
	}

	public static void main(String[] args) throws IOException {
		File file = new File("c:/test.txt");
		/* try{ */FileWriter writer = new FileWriter(file);// �ļ�д����,����������д�뵽�ļ���
		/*
		 * }catch(Exception exception) { System.out.println(exception.getMessage()); }
		 */
		// �ж�����ļ��Ƿ����
		System.out.println(file.exists());
		writer.close();
	}

}
