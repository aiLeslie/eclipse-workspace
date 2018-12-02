package com.bin.javabase.bean;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bin.javabase.Test;

/**
 * 
 * ��Ŀ���ƣ�SpringProject �����ƣ�Service �������� �����ˣ������ ����ʱ�䣺2018��9��18�� ����10:05:31
 * 
 * @version 1.0
 */
@Component("service")
@Scope("singleton")
public class Service {
	// �Գ־ò������
	@Autowired
	private Dao dao;

	public void load() {
		System.out.println("����������");
		System.out.println("���ӳ־ò�");

		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				if (dao != null)
					System.out.println("���ӳɹ�!");
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
