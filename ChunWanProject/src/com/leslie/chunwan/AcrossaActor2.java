package com.leslie.chunwan;

public class AcrossaActor2 extends Actor {

	public AcrossaActor2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AcrossaActor2(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void performs() {
		System.out.println("相声演员" + getName() + "说相声讲究拖鞋就唱~~~");
	}
}
