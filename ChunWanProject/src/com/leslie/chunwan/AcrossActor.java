package com.leslie.chunwan;

public class AcrossActor extends Actor {

	public AcrossActor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AcrossActor(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void performs() {
		System.out.println("������Ա" + getName() + "˵����������������,��ֻ��˵:��������");
	}
	
}
