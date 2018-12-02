package com.leslie.javabase;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


public class HotFixTest {

	public final static String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator;

	public static void main(String[] args) throws Exception {
		URLClassLoader loader = null; // �������
		@SuppressWarnings("unused")
		URL url = null;

		// ����JVM: �û�������Ĵ��λ��
		File file = new File("F:\\eclipse-workspace\\ClassLoaderProject\\Print.jar"); // ʹ������jar��·��
		// ����ļ�����
		if (file.exists()) {

//			url = new URL("file:" + file.getAbsolutePath());// ����url����

			URL[] classLoaderUrls = new URL[] { new URL("file:" + dir) }; // ʹ���û�������·��

//			loader = new URLClassLoader(new URL[] { url }); // ʵ�����������

			loader = new URLClassLoader(classLoaderUrls); // ʵ�����������

			while (true) {
				
				invonkeMethod(loader.loadClass("com.leslie.javabase.Test"));
				Thread.sleep(5000l);
			}

		} else {
			System.err.println("��·�������ҵ����ļ�");
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
