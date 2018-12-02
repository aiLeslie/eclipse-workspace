package com.bin.javabase.NetworkCrawlerDemo;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * �൱��С�����ݿ�
* ��Ŀ���ƣ�CollectionDemo   
* �����ƣ�LinkQueue   
* �������������Ӷ���
* �����ˣ������   
* ����ʱ�䣺2017��12��10�� ����12:24:03   
* @version 1.0
 */
public class LinkQueue {
	public static final int URL_SIZE = 10;
	/**�ѷ������Ӽ���*/
	private static Set<String> vistedUrl = new HashSet<String>();
	/**���������Ӽ���*/
	private static Queue<String> unVistedUrl = new ArrayDeque<String>();
	
	public static boolean addUnvisted(String url) {
		if(url == null || url.equals("")) {//��������ַ�����Ϊ�պ���Ч��,ֱ�ӷ���
			return false;
		}
		if(vistedUrl.contains(url) || unVistedUrl.contains(url)) {//��������ַ��������ڶ�����,ֱ�ӷ���
			return false;
		}
		unVistedUrl.offer(url);
		System.out.println(">>> " + url + " <����unVistedUrl������>");
		return true;
	}

	public static Set<String> getVistedUrl() {
		return vistedUrl;
	}

	public static Queue<String> getUnVistedUrl() {
		return unVistedUrl;
	}


}
