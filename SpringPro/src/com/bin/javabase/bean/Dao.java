package com.bin.javabase.bean;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/**
 * 持久层
* 项目名称：SpringProject   
* 类名称：Dao   
* 类描述：
* 创建人：李玮斌   
* 创建时间：2018年9月17日 下午6:50:09   
* @version 1.0
 */
@Component("dao")
@Scope("singleton")
public class Dao {
	public void load() {
		System.out.print("持久层正在加载>>>");
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
			System.out.println("加载成功!");
				
			}
		}, 500);
	}

}
