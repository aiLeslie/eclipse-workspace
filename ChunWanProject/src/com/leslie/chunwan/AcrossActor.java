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
		System.out.println("相声演员" + getName() + "说现在相声不景气啦,我只能说:想死你们");
	}
	
}
