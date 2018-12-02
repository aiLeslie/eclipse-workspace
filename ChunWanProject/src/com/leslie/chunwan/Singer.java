package com.leslie.chunwan;
/**
 * 歌唱演员类
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
		System.out.println("歌唱演员" + getName() +"表演歌唱节目" );	
		}

}
