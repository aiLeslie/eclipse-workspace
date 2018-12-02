package cn.bin.javabase.chapter.c2;

import java.util.Scanner;
/**
 * 
* 项目名称：Calc   
* 类名称：BinTransition   
* 类描述：
* 创建人：李玮斌   
* 创建时间：2017年10月28日 下午8:19:39   
* @version 1.0
 */
public class BinTransition {

	public BinTransition() {
		// TODO Auto-generated constructor stub
	}
	public static void  main(String args[]) {
		Scanner input = new Scanner (System.in);
		int i = 0;
		System.out.print("请输入二进制数:");
	      StringBuffer temp = new StringBuffer(input.next());
          int deci = 0;
          for(i = 0 ;i < temp.length();i++) {
        	  System.out.println("2的权" + (Integer.parseInt(temp.reverse().charAt(i) + "") * (int)Math.pow(2, i)));
        	  int a = (Integer.parseInt(temp.reverse().charAt(i) + "") * (int)Math.pow(2, i));
        	  deci = deci + a;
        	  System.out.println(deci);
          }
          //System.out.println(temp.reverse().toString());
		System.out.println(deci);
		input.close();
	}
}
