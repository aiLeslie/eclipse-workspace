package cn.bin.javabase.chapter.c2;

import java.util.Scanner;
/**
 * 
* ��Ŀ���ƣ�Calc   
* �����ƣ�BinTransition   
* ��������
* �����ˣ������   
* ����ʱ�䣺2017��10��28�� ����8:19:39   
* @version 1.0
 */
public class BinTransition {

	public BinTransition() {
		// TODO Auto-generated constructor stub
	}
	public static void  main(String args[]) {
		Scanner input = new Scanner (System.in);
		int i = 0;
		System.out.print("�������������:");
	      StringBuffer temp = new StringBuffer(input.next());
          int deci = 0;
          for(i = 0 ;i < temp.length();i++) {
        	  System.out.println("2��Ȩ" + (Integer.parseInt(temp.reverse().charAt(i) + "") * (int)Math.pow(2, i)));
        	  int a = (Integer.parseInt(temp.reverse().charAt(i) + "") * (int)Math.pow(2, i));
        	  deci = deci + a;
        	  System.out.println(deci);
          }
          //System.out.println(temp.reverse().toString());
		System.out.println(deci);
		input.close();
	}
}
