package com.bin.javabase.NetworkCrawlerDemo;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 相当于小型数据库
* 项目名称：CollectionDemo   
* 类名称：LinkQueue   
* 类描述：超连接队列
* 创建人：李玮斌   
* 创建时间：2017年12月10日 下午12:24:03   
* @version 1.0
 */
public class LinkQueue {
	public static final int URL_SIZE = 10;
	/**已访问连接集合*/
	private static Set<String> vistedUrl = new HashSet<String>();
	/**待访问连接集合*/
	private static Queue<String> unVistedUrl = new ArrayDeque<String>();
	
	public static boolean addUnvisted(String url) {
		if(url == null || url.equals("")) {//如果连接字符串是为空和无效的,直接返回
			return false;
		}
		if(vistedUrl.contains(url) || unVistedUrl.contains(url)) {//如果连接字符串是已在队列中,直接返回
			return false;
		}
		unVistedUrl.offer(url);
		System.out.println(">>> " + url + " <进入unVistedUrl队列中>");
		return true;
	}

	public static Set<String> getVistedUrl() {
		return vistedUrl;
	}

	public static Queue<String> getUnVistedUrl() {
		return unVistedUrl;
	}


}
