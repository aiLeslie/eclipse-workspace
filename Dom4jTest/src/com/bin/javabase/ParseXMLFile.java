package com.bin.javabase;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXMLFile {
	public static void main(String[] args) {
		parseXML("./data.xml");
	}
	public static void parseXML(String filePath){
		
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File(filePath));
			Element root = document.getRootElement();
			System.out.println("父节点：" + root.getName());
			List<Element> elements = root.elements();
			System.out.println("父节点中有" + elements.size() + "个节点");
			for (int i = 0 ; i < elements.size();i++) {
				Element e = elements.get(i);
				System.out.print(e.getName() + ":");
				
				for (Attribute a : e.attributes()) {
					System.out.print(a.getName() + " - " + a.getValue());
					System.out.print("\t");
				}
				System.out.println();
			}
			
			
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
