import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Date;

public class FileDemo {

	final static String FilePath = ".";

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

		File file = new File(FilePath);
		// JFileChooser fileChooser = new JFileChooser(new File("."));
		// fileChooser.showOpenDialog(null);

		// System.out.println(fileName(FilePath));
		// System.out.println(name(FilePath));
		System.out.println("�ļ�/�ļ����Ƿ����:" + file.exists());
		System.out.println("�Ƿ����ļ�:" + file.isFile());
		System.out.println("�Ƿ���Ŀ¼:" + file.isDirectory());
		System.out.println("����·��:" + file.getAbsolutePath());
		System.out.println("·��:" + file.getPath());
		System.out.println("����޸�ʱ��:" + new Date(file.lastModified()).toLocaleString());
		System.out.println("�Ƿ�����" + file.isHidden());
		System.out.println("�Ƿ�ɶ�:" + file.canRead());
		System.out.println("�Ƿ��д:" + file.canWrite());
		System.out.println(file.length());
		System.out.println();

		// //ʹ��File�ഴ���ļ�
		// if(!file.exists()) {
		// if(file.isFile()) {
		// file.createNewFile();
		// System.out.println("�����ļ��ɹ�");
		// }
		// else {
		// file.mkdir();
		// System.out.println("����Ŀ¼�ɹ�");
		// }
		//
		// }
		//
		// //ɾ���ļ�
		// if(file.exists()) {
		// //file.delete();//����ɾ���ļ�/Ŀ¼
		// //file.deleteOnExit();//�ڳ������ǰ���ļ�ɾ��
		// }
		// //mkdir()�����˳���·����ָ��Ŀ¼(��ֻ�ܴ���һ��Ŀ¼,����Ҫ���ڸ�Ŀ¼)
		// //mikdirs()�����˳���ָ��Ŀ¼,�������б��뵫�����ڵĸ�ϵĿ¼.(�����Դ����༶Ŀ¼,�����Ƿ���ڸ�Ŀ¼) - �༶Ŀ¼ʹ��
		//
		// �г���Ŀ¼�µ������ļ�/�ļ���
		String[] fileName = file.list(new DirFilter());
		for (int i = 0; i < fileName.length; i++) {
			System.out.println(fileName[i]);
		}

	}

	// public static String fileName(String filePath) {
	// int i = Integer.MAX_VALUE;
	// for(i = filePath.length() - 1;i >=0 ;i--) {
	// if(filePath.charAt(i) == '/') break;
	// }
	// if(i == -1)return filePath.trim();
	// i++;
	// StringBuffer temp = new StringBuffer();
	//
	// temp.append(filePath.substring(i, filePath.length()));
	// return temp.toString().trim();
	//
	// }
	//
	// public static String name(String filePath) {
	// int i = 0;
	// i = filePath.lastIndexOf('/');
	// return filePath.substring(++i,filePath.length() ).trim();
	// }
	static class DirFilter implements FilenameFilter {

		@Override
		public boolean accept(File dir, String name) {
			if (name.endsWith("src"))
				return true;
			return false;
		}

	}
}
