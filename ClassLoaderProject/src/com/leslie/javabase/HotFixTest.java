package com.leslie.javabase;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


public class HotFixTest {

	public final static String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator;

	public static void main(String[] args) throws Exception {
		URLClassLoader loader = null; // 类加载器
		@SuppressWarnings("unused")
		URL url = null;

		// 告诉JVM: 用户程序类的存放位置
		File file = new File("F:\\eclipse-workspace\\ClassLoaderProject\\Print.jar"); // 使用外置jar包路径
		// 如果文件存在
		if (file.exists()) {

//			url = new URL("file:" + file.getAbsolutePath());// 创建url对象

			URL[] classLoaderUrls = new URL[] { new URL("file:" + dir) }; // 使用用户程序类路径

//			loader = new URLClassLoader(new URL[] { url }); // 实例化类加载器

			loader = new URLClassLoader(classLoaderUrls); // 实例化类加载器

			while (true) {
				
				invonkeMethod(loader.loadClass("com.leslie.javabase.Test"));
				Thread.sleep(5000l);
			}

		} else {
			System.err.println("该路径不能找到该文件");
		}

	}

	private static boolean invonkeMethod(Class<?> classType) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Method method;
		method = classType.getMethod("printMsg", new Class[] { String.class });
		if (method == null) {
			return false;
		}
		method.invoke(classType.newInstance(), new Object[] { "Hello World!" });
		return true;

	}
}
