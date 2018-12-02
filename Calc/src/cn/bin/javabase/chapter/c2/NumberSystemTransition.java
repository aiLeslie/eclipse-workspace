package cn.bin.javabase.chapter.c2;

import java.util.Scanner;

public class NumberSystemTransition {

	public NumberSystemTransition() {
		// TODO Auto-generated constructor stub
	}
	
	public static void  main(String args[]) {
		Scanner input = new Scanner (System.in);
		System.out.print("请输入十进制数");
		int number = -1;
		StringBuffer result = new StringBuffer();
		number = input.nextInt();
		int temp = number;
		while(true){
			result.append( temp % 2 );
			temp = temp / 2;
			if(temp == 0)break;
		}
		System.out.println("二进制数:" + Integer.parseInt(result.reverse().toString()));
		System.out.printf("八进制数:%o\n",number);
		System.out.printf("十六进制数:%x\n",number);
		System.out.printf("十六进制数:" + String.format("%x",number));
		input.close();
	}

}
