package com.leslie.handlerPro;

import com.leslie.handlerPro.handlers.Myhandler;
import com.leslie.handlerPro.handlers.TempHandler;


public class Test {

	public static void main(String args[]) throws Exception {

		TempHandler tempHandler = new TempHandler();
		tempHandler.getAlarm().setAlarm(new TempHandler.TempAlarm.Alarm() {
			@Override
			public void onAlarm() {
				System.out.println("on alarm()");
			}
		});
		for (int i = 0; i < 11; i++)
			tempHandler.parse("100");
		tempHandler.clsoe();

		Myhandler myhandler = new Myhandler();
		myhandler.parse(null);
		myhandler.clsoe();

		
		

		
		
		
	}

}
