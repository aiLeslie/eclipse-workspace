package com.bin.javabase.bean;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/**
 * �־ò�
* ��Ŀ���ƣ�SpringProject   
* �����ƣ�Dao   
* ��������
* �����ˣ������   
* ����ʱ�䣺2018��9��17�� ����6:50:09   
* @version 1.0
 */
@Component("dao")
@Scope("singleton")
public class Dao {
	public void load() {
		System.out.print("�־ò����ڼ���>>>");
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
			System.out.println("���سɹ�!");
				
			}
		}, 500);
	}

}
