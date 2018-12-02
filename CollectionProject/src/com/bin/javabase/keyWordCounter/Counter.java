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
* 项目名称：CollectionDemo   
* 类名称：Counter   
* 类描述：统计关键字出现次数
* 创建人：李玮斌   
* 创建时间：2017年12月3日 下午6:21:27   
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
 * 1.获得java源文件中的字符串(行的集合,stringBuffer)
 * 2.遍历关键字集合,统计每一个关键字在源文件中出现的出现次数 -将关键字和次数以键值对存放在Map集合中
 * 3.遍历Map集合(以关键字 次数来排序)
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
