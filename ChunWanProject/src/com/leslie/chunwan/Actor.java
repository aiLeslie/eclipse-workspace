package com.leslie.chunwan;
/**
 * 演员父类
 * @author Administrator
 *
 */
public abstract class Actor {
	private String name;
	
	public void performs(){
		System.out.println("演员" + name + "正在表演精彩节目");
	}
	
	public Actor() {
		super();
	}
	public Actor(String name){
		//this.name = name;
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
