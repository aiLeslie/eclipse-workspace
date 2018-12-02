package com.bin.javabase;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * 项目名称：Dom4jTest 类名称：XMLparse 类描述：解析xml文件 创建人：李玮斌 创建时间：2018年3月13日 下午10:17:35
 * 
 * @version 1.0
 */
public final class XMLparse {
	private static Element parentNode = null;
	private static int i = 0;
	//private static int currentIndex = -1;//记录循环当前指引
	

	public static void main(String[] args) {
		parseXMLFileLocation("./xml.xml");
		
	}
	private static void parseXMLFileLocation(String filePath) {
		try {
			// 实例化SAXReader对象
			SAXReader reader = new SAXReader();
			// 将file对象转换成Document对象
			Document document = reader.read(new File(filePath));
			Element rootElement = document.getRootElement();
			printAllElements(rootElement);
			parentNode = null;

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}

	private static void printAllAttribute(List<Attribute> attributeList) {
		for (Attribute attr : attributeList) {
			// 每循环一次，解析此节点的一个【属性=值】，没有则输出空
			String name = attr.getName();
			String value = attr.getValue();
			System.out.println(getSeparator() + name + " = " + value);
		}
	}

	private static void printAllElements(Element rootElement) {
		
		if (parentNode == null) {
			parentNode = rootElement;
			System.out.println("父节点: " + rootElement.getName());
			printAllAttribute(parentNode.attributes());
			System.out.println();
		}
		i++;
		//if (currentIndex == -1)currentIndex = i;
		
		for (Element e : rootElement.elements()) {
			// 每循环一次，解析此节点的一个【属性=值】，没有则输出空
				System.out.println(getSeparator() + "子节点: " + e.getName());
				printAllAttribute(e.attributes());
				System.out.println();
			if (e.elements() != null) {
				printAllElements(e);
			}
			i = 1;
			
		}
		
	}
	/*
	 * 打印节点区分间隔
	 */
	private static String getSeparator() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int j = 0 ; j < i ; j ++) {
			stringBuilder.append("\t");
		}
		return stringBuilder.toString();
	}
}
