package com.bin.javabase.keyWordCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
* ��Ŀ���ƣ�CollectionDemo   
* �����ƣ�Counter   
* ��������ͳ�ƹؼ��ֳ��ִ���
* �����ˣ������   
* ����ʱ�䣺2017��12��3�� ����6:21:27   
* @version 1.0
 */
/**
 */
public class Counter {
	final static String fileName = "src/com/bin/javabase/keyWordCounter/Counter.java";
	static List<String> list = null; 
	static final String[] keyWords = {"package","import","public","class","void","final","try","while","if","return","static","new"};
	static Set<String>keyWordsSet = new HashSet<>();
	static HashMap<String,Integer> map = new HashMap<>();
/**
 * 1.���javaԴ�ļ��е��ַ���(�еļ���,stringBuffer)
 * 2.�����ؼ��ּ���,ͳ��ÿһ���ؼ�����Դ�ļ��г��ֵĳ��ִ��� -���ؼ��ֺʹ����Լ�ֵ�Դ����Map������
 * 3.����Map����(�Թؼ��� ����������)
 */
	public static void count(String fileName) {
		list = readSourceFile(fileName);
		for (String string : list) {
			System.out.println(string);
		}
		
		
		keyWordsSet.addAll(Arrays.asList(keyWords));
		keyWordsSet.forEach(action -> map.put(action, 0));
		
		for (String string : list) {
			
			for (String key : keyWords) {
				int count = 0;
				if(string.indexOf(key) != -1) {					
//					count++;
//					string = string.substring(string.indexOf(key) + key.length());
					do{
						count++;
						if(string.indexOf(key) + key.length() == string.length())break;
						string = string.substring(string.indexOf(key) + key.length());
					}while(string.indexOf(key) != -1); 
					map.replace(key, map.get(key) + count);
					
				}else {
					map.replace(key, map.get(key) + count);
					continue;
				}
			}
		}
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for (Map.Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() +"~" + entry.getValue());
		}
				 
	}
	public static List<String> readSourceFile(String fileName) {
		List<String> contentList = new ArrayList<String>();
		try (
			FileReader freader = new FileReader(fileName);
			BufferedReader breader = new BufferedReader(freader)){
			String line = null;
			while((line = breader.readLine()) != null){
				contentList.add(line.trim());
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return contentList;
		
		
	}
	public static void main(String[] args) {
		count(fileName);
	}
	
}
