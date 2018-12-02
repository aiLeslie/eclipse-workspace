package com.bin.javabase;


import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class CreateXMLFile {
	public static void main(String[] args){
		Document document = DocumentHelper.createDocument();
		Element rootEldocument = document.addElement("users");
		rootEldocument.addElement("user").addAttribute("id", "2").addAttribute("name","MIng");
		FileWriter out;
		try {
			out = new FileWriter("./data.xml");
			document.write(out);
			out.close();
			System.out.println("–¥»Î≥…π¶");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
}
