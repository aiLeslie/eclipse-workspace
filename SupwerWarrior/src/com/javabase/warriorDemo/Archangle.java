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
		System.out.println("我飞啊飞飞到天上了");
		
	}

	@Override
	public void Swiming() {
		System.out.println("我游啊游游到海底了");
		
	}

	@Override
	public void move() {
		System.out.println("我走啊走走到地球的另一边了");
		
	}
	

}
