package com.bin.javabase.collectionDemo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



/**
 * ����ͼ�����÷�
* ��Ŀ���ƣ�CollectionDemo   
* �����ƣ�MapDemo   
* ��������
* �����ˣ������   
* ����ʱ�䣺2017��12��3�� ����9:02:46   
* @version 1.0
 */
public class MapDemo {

	public MapDemo() {
		
	}

	public static void main(String[] args) {
		map�Ļ����÷�();

	}
	public static void map�Ļ����÷�() {
		HashMap<String, Integer> hashMap = new HashMap<String , Integer>();
		hashMap.put("Monkey.D.Luffy",18);
		hashMap.put("Nami", 19);
		hashMap.put("sanji", 25);
		hashMap.put("Nico Robin",26);
		hashMap.put("Roronoa", 21);
		System.out.println("hashMap:" + hashMap);
		System.out.println();
		
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		linkedHashMap.put("Monkey.D.Luffy",18);
		linkedHashMap.put("Nami", 19);
		linkedHashMap.put("sanji", 25);
		linkedHashMap.put("Nico Robin",26);
		linkedHashMap.put("Roronoa", 21);
		System.out.println("linkedHashMap:" + linkedHashMap);
		System.out.println();
		
		/**
		 * �Զ���Ƚ�����������
		 */
		TreeMap<String, Integer> treeMap1 = new TreeMap<String, Integer>();
		treeMap1.put("Monkey.D.Luffy",18);//Map����ļ�ֵ������ֻ��һ��(Ԫ�ز��ظ�)
		treeMap1.put("Monkey.D.Luffy",18);
		treeMap1.put("Monkey.D.Luffy",18);
		treeMap1.put("Monkey.D.Luffy",18);
		treeMap1.put("Nami", 19);
		treeMap1.put("sanji", 25);
		treeMap1.put("Nico Robin",26);
		treeMap1.put("Roronoa", 21);
		System.out.println("treeMap:" + treeMap1);
		System.out.println();
		
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(new MyTreeCompartorByValue(treeMap1));
//		treeMap.put("Monkey.D.Luffy",18);
//		treeMap.put("Nami", 19);
//		treeMap.put("sanji", 25);
//		treeMap.put("Nico Robin",26);
//		treeMap.put("Roronoa", 21);
//		
		treeMap.putAll(treeMap1);
		System.out.println("treeMap:" + treeMap);
		System.out.println();
		
		//System.out.println("R" +(int)'R' +" S" + (int)'s');
		
		
		System.out.println("��һ�ֱ�����ʽ:ͨ��Map.keySet����key,ͨ��keyȡ����Ӧvalue");
		for(String key :treeMap.keySet()){
			System.out.println(key + "--" + treeMap.get(key));
		}
		
		System.out.println("�ڶ��ֱ�����ʽ:ͨ��Map.entrySet�õ�Set����ʹ�õ���������entry�������key��value -- ������,����ʹ�ñ��������б���");
		Set<Map.Entry<String,Integer>> entrySet = treeMap.entrySet();
		Iterator<Map.Entry<String,Integer>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Map.Entry<String,Integer> entry = iterator.next();
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
		
		System.out.println("�ڶ��ֱ�����ʽ:ͨ��Map.entrySetʹ��foreach���б���");
		for (Map.Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + "==" + entry.getValue());
		}
		
	}

}
/**
 * �Զ���Ƚ�����������
* ��Ŀ���ƣ�CollectionDemo   
* �����ƣ�MyTreeCompartor   
* ��������Ĭ�������,map�ıȽ���ֻ��key��������
* �����ˣ������   
* ����ʱ�䣺2017��12��3�� ����9:47:04   
* @version 1.0
 */
class MyTreeCompartor implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		
		return -arg0.compareTo(arg1);
	}

	
	
}
/**
 * �Զ���Ƚ�����������
* ��Ŀ���ƣ�CollectionDemo   
* �����ƣ�MyTreeCompartor   
* ���������޸�map�ıȽ���ֻ��value��������
* �����ˣ������   
* ����ʱ�䣺2017��12��3�� ����9:54:05   
* @version 1.0
 */
class MyTreeCompartorByValue implements Comparator<String>{
	private TreeMap<String,Integer> map;
	public MyTreeCompartorByValue( TreeMap<String,Integer> map) {
		this.map = map;
	}
	public MyTreeCompartorByValue() {
		
	}

	@Override
	public int compare(String arg0, String arg1) {
		
		return -((TreeMap<String,Integer>)map).get(arg0).compareTo(((TreeMap<String,Integer>)map).get(arg1));
	}

	
	
}
