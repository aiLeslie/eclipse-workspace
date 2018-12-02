package com.leslie.javabase.chaper;

import com.leslie.javabase.chaper.iface.IInkBox;
import com.leslie.javabase.chaper.iface.IPaper;


public class PrinterDemo {

	public static void main(String []args) {
		Printer printer = new Printer();
		/*printer.setInkbox(new Color());
		printer.setPaper( new A4());*/
		/**
		 * 匿名类实现接口
		 */
		printer.setInkbox(new IInkBox() {

			@Override
			public String getColor() {
				// TODO Auto-generated method stub
				return "红色";
			}
			
		});
		printer.setPaper(new IPaper(){

			@Override
			public String getSize() {
				
				return "A5";
			}
			
		});
		printer.print("Hello World");
		
		
		System.out.println(printer.getPaper());
	}

}
