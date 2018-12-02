package com.bin.javabase.bean;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bin.javabase.Test;

/**
 * 
 * 项目名称：SpringProject 类名称：Service 类描述： 创建人：李玮斌 创建时间：2018年9月18日 下午10:05:31
 * 
 * @version 1.0
 */
@Component("service")
@Scope("singleton")
public class Service {
	// 对持久层的引用
	@Autowired
	private Dao dao;

	public void load() {
		System.out.println("开启服务器");
		System.out.println("连接持久层");

		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				if (dao != null)
					System.out.println("连接成功!");
				dao.load();

			}
		}, 500);

	}

	public static void main(String[] args) {
		Service instance = new Test<Service>("Annotation.xml").getInstance("service");
		System.out.println(instance);
		instance.load();

	}

}
