package com.javabase.warriorDemo;

import com.javabase.warriorDemo.iface.IFly;
import com.javabase.warriorDemo.iface.IRunning;
import com.javabase.warriorDemo.iface.IShipping;

public class Archangle implements IRunning,IShipping,IFly {
	public String name ;
	public Archangle() {
		
	}

	@Override
	public void Flying() {
		System.out.println("�ҷɰ��ɷɵ�������");
		
	}

	@Override
	public void Swiming() {
		System.out.println("���ΰ����ε�������");
		
	}

	@Override
	public void move() {
		System.out.println("���߰����ߵ��������һ����");
		
	}
	

}
