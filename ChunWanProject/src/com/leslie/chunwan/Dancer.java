package com.leslie.chunwan;
/**
 * 舞蹈演员类
 * @author Administrator
 *
 */
public class Dancer extends Actor {

	public Dancer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dancer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void performs(){
		System.out.println("舞蹈演员" + getName() + "表演在展现婀娜多姿的舞蹈");
	}
	
}
