package cn.bin.javabase.chapter.c2;

import java.util.Scanner;

public class NumberSystemTransition {

	public NumberSystemTransition() {
		// TODO Auto-generated constructor stub
	}
	
	public static void  main(String args[]) {
		Scanner input = new Scanner (System.in);
		System.out.print("������ʮ������");
		int number = -1;
		StringBuffer result = new StringBuffer();
		number = input.nextInt();
		int temp = number;
		while(true){
			result.append( temp % 2 );
			temp = temp / 2;
			if(temp == 0)break;
		}
		System.out.println("��������:" + Integer.parseInt(result.reverse().toString()));
		System.out.printf("�˽�����:%o\n",number);
		System.out.printf("ʮ��������:%x\n",number);
		System.out.printf("ʮ��������:" + String.format("%x",number));
		input.close();
	}

}
