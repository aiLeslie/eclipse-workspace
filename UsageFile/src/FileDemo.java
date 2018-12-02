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
		System.out.println("文件/文件夹是否存在:" + file.exists());
		System.out.println("是否是文件:" + file.isFile());
		System.out.println("是否是目录:" + file.isDirectory());
		System.out.println("绝对路径:" + file.getAbsolutePath());
		System.out.println("路径:" + file.getPath());
		System.out.println("最后修改时间:" + new Date(file.lastModified()).toLocaleString());
		System.out.println("是否隐藏" + file.isHidden());
		System.out.println("是否可读:" + file.canRead());
		System.out.println("是否可写:" + file.canWrite());
		System.out.println(file.length());
		System.out.println();

		// //使用File类创建文件
		// if(!file.exists()) {
		// if(file.isFile()) {
		// file.createNewFile();
		// System.out.println("创建文件成功");
		// }
		// else {
		// file.mkdir();
		// System.out.println("创建目录成功");
		// }
		//
		// }
		//
		// //删除文件
		// if(file.exists()) {
		// //file.delete();//立即删除文件/目录
		// //file.deleteOnExit();//在程序结束前将文件删除
		// }
		// //mkdir()创建此抽象路径名指定目录(及只能创建一级目录,且需要存在父目录)
		// //mikdirs()创建此抽象指定目录,包括所有必须但不存在的父系目录.(及可以创建多级目录,无论是否存在父目录) - 多级目录使用
		//
		// 列出当目录下的所有文件/文件夹
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
