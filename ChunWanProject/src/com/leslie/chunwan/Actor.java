package com.leslie.chunwan;
/**
 * ��Ա����
 * @author Administrator
 *
 */
public abstract class Actor {
	private String name;
	
	public void performs(){
		System.out.println("��Ա" + name + "���ڱ��ݾ��ʽ�Ŀ");
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
