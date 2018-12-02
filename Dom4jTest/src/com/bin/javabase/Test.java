package com.bin.javabase;
import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
    public static void parserNode(Element ele){ 
        System.out.println(ele.getName()+":"+ele.getText().trim());  
        //��Users���ڵ㿪ʼ������������=ֵ������ʽ��Ϊһ��Attribute����洢��List������  
        List<Attribute> attrList = ele.attributes();  
        for(Attribute attr : attrList){  
            //ÿѭ��һ�Σ������˽ڵ��һ��������=ֵ����û���������  
            String name = attr.getName();  
            String value = attr.getValue();  
            System.out.println(name+" = "+value);  
        } 
          
        List<Element> eleList = ele.elements();  
        //�ݹ�������ڵ��µ������ӽڵ�  
        for(Element e : eleList){  
            parserNode(e);  
        }  
    }  
      
    public static void main(String[] args) {  
        SAXReader saxReader = new SAXReader();  
        try {  
            Document document = saxReader.read((new File("./xml.xml")));  
            Element ele = document.getRootElement();  
            parserNode(ele);  
        } catch (DocumentException e) {  
            e.printStackTrace();  
        }  
    }  
} 

