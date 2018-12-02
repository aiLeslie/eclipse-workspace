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
 * ��Ŀ���ƣ�Dom4jTest �����ƣ�XMLparse ������������xml�ļ� �����ˣ������ ����ʱ�䣺2018��3��13�� ����10:17:35
 * 
 * @version 1.0
 */
public final class XMLparse {
	private static Element parentNode = null;
	private static int i = 0;
	//private static int currentIndex = -1;//��¼ѭ����ǰָ��
	

	public static void main(String[] args) {
		parseXMLFileLocation("./xml.xml");
		
	}
	private static void parseXMLFileLocation(String filePath) {
		try {
			// ʵ����SAXReader����
			SAXReader reader = new SAXReader();
			// ��file����ת����Document����
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
			// ÿѭ��һ�Σ������˽ڵ��һ��������=ֵ����û���������
			String name = attr.getName();
			String value = attr.getValue();
			System.out.println(getSeparator() + name + " = " + value);
		}
	}

	private static void printAllElements(Element rootElement) {
		
		if (parentNode == null) {
			parentNode = rootElement;
			System.out.println("���ڵ�: " + rootElement.getName());
			printAllAttribute(parentNode.attributes());
			System.out.println();
		}
		i++;
		//if (currentIndex == -1)currentIndex = i;
		
		for (Element e : rootElement.elements()) {
			// ÿѭ��һ�Σ������˽ڵ��һ��������=ֵ����û���������
				System.out.println(getSeparator() + "�ӽڵ�: " + e.getName());
				printAllAttribute(e.attributes());
				System.out.println();
			if (e.elements() != null) {
				printAllElements(e);
			}
			i = 1;
			
		}
		
	}
	/*
	 * ��ӡ�ڵ����ּ��
	 */
	private static String getSeparator() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int j = 0 ; j < i ; j ++) {
			stringBuilder.append("\t");
		}
		return stringBuilder.toString();
	}
}
