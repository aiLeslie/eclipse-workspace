package com.bin.javabase.ioc;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Timer;
import java.util.TimerTask;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bin.javabase.bean.User;

public class ScopeTest {
	// bean scope 默认属性值为singleton(单例)

	public static String SCOPE_SINGLETONE = "singleton";
	public static String SCOPE_PROTOTYPE = "prototype";
	public static String CONFIG_PATH = "src/ApplicationContext.xml";

	public static void main(String[] args) throws IOException {
		/**
		 * 比较scope属性值
		 */
		System.out.println("单例模式");
		// 设置scope属性值(单例模式)
//		setScope(SCOPE_SINGLETONE);

		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				matchBean();

			}
		}, 5000);

		System.out.println();
		System.out.println();

//		System.out.println("多个实例模式");
//		// 设置scope属性值(多个实例模式)
//		setScope(SCOPE_PROTOTYPE);
//
//		new Timer().schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				matchBean();
//				
//			}
//		}, 5000); 

	}

	private static void matchBean() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		System.out.println(context.toString());

		User user1 = (User) context.getBean("user1");

		System.out.println("user1: " + user1);

		User user2 = (User) context.getBean("user1");

		System.out.println("user2: " + user2);

		System.out.println("user1 和 user2 指向相同对象?" + (user1 == user2));
	}

	/**
	 * 设置bean节点中scope属性
	 * 
	 * @param scopeValue
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void setScope(String scopeValue) throws DocumentException, IOException {
		// 获得输入流读取内容
		SAXReader saxReader = new SAXReader();
		// 获取document的实例
		Document document = saxReader.read((new File(CONFIG_PATH)));
		// 设置编码
		document.setXMLEncoding("utf-8");
		// 获得根节点
		Element root = document.getRootElement();
		// 获得要修改bean元素
		Element element = (Element) root.elements().get(0);
		// 获得bean元素属性
		Attribute attribute = element.attribute("scope");
		// 设置属性
		attribute.setValue(scopeValue);

		// 保存修改后xml
		Writer writer = new PrintWriter(CONFIG_PATH, "utf-8");

		document.write(writer);

		writer.close();

	}
}
