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
	// bean scope Ĭ������ֵΪsingleton(����)

	public static String SCOPE_SINGLETONE = "singleton";
	public static String SCOPE_PROTOTYPE = "prototype";
	public static String CONFIG_PATH = "src/ApplicationContext.xml";

	public static void main(String[] args) throws IOException {
		/**
		 * �Ƚ�scope����ֵ
		 */
		System.out.println("����ģʽ");
		// ����scope����ֵ(����ģʽ)
//		setScope(SCOPE_SINGLETONE);

		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				matchBean();

			}
		}, 5000);

		System.out.println();
		System.out.println();

//		System.out.println("���ʵ��ģʽ");
//		// ����scope����ֵ(���ʵ��ģʽ)
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

		System.out.println("user1 �� user2 ָ����ͬ����?" + (user1 == user2));
	}

	/**
	 * ����bean�ڵ���scope����
	 * 
	 * @param scopeValue
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void setScope(String scopeValue) throws DocumentException, IOException {
		// �����������ȡ����
		SAXReader saxReader = new SAXReader();
		// ��ȡdocument��ʵ��
		Document document = saxReader.read((new File(CONFIG_PATH)));
		// ���ñ���
		document.setXMLEncoding("utf-8");
		// ��ø��ڵ�
		Element root = document.getRootElement();
		// ���Ҫ�޸�beanԪ��
		Element element = (Element) root.elements().get(0);
		// ���beanԪ������
		Attribute attribute = element.attribute("scope");
		// ��������
		attribute.setValue(scopeValue);

		// �����޸ĺ�xml
		Writer writer = new PrintWriter(CONFIG_PATH, "utf-8");

		document.write(writer);

		writer.close();

	}
}
