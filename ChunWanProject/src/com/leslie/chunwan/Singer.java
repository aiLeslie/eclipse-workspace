package com.leslie.chunwan;
/**
 * �質��Ա��
 * @author Administrator
 *
 */
public class Singer extends Actor {

	public Singer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Singer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void performs(){
		System.out.println("�質��Ա" + getName() +"���ݸ質��Ŀ" );	
		}

}
