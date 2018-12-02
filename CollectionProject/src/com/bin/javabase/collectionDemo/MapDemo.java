package com.bin.javabase.collectionDemo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



/**
 * 三种图基本用法
* 项目名称：CollectionDemo   
* 类名称：MapDemo   
* 类描述：
* 创建人：李玮斌   
* 创建时间：2017年12月3日 上午9:02:46   
* @version 1.0
 */
public class MapDemo {

	public MapDemo() {
		
	}

	public static void main(String[] args) {
		map的基本用法();

	}
	public static void map的基本用法() {
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
		 * 自定义比较器进行排序
		 */
		TreeMap<String, Integer> treeMap1 = new TreeMap<String, Integer>();
		treeMap1.put("Monkey.D.Luffy",18);//Map里面的键值对有且只有一个(元素不重复)
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
		
		
		System.out.println("第一种遍历方式:通过Map.keySet遍历key,通过key取出对应value");
		for(String key :treeMap.keySet()){
			System.out.println(key + "--" + treeMap.get(key));
		}
		
		System.out.println("第二种遍历方式:通过Map.entrySet得到Set对象使用迭代器遍历entry对象里的key和value -- 容量大,建议使用本方法进行遍历");
		Set<Map.Entry<String,Integer>> entrySet = treeMap.entrySet();
		Iterator<Map.Entry<String,Integer>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Map.Entry<String,Integer> entry = iterator.next();
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
		
		System.out.println("第二种遍历方式:通过Map.entrySet使用foreach进行遍历");
		for (Map.Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + "==" + entry.getValue());
		}
		
	}

}
/**
 * 自定义比较器进行排序
* 项目名称：CollectionDemo   
* 类名称：MyTreeCompartor   
* 类描述：默认情况下,map的比较器只对key进行排序
* 创建人：李玮斌   
* 创建时间：2017年12月3日 上午9:47:04   
* @version 1.0
 */
class MyTreeCompartor implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		
		return -arg0.compareTo(arg1);
	}

	
	
}
/**
 * 自定义比较器进行排序
* 项目名称：CollectionDemo   
* 类名称：MyTreeCompartor   
* 类描述：修改map的比较器只对value进行排序
* 创建人：李玮斌   
* 创建时间：2017年12月3日 上午9:54:05   
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
