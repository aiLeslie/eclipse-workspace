package cn.bin.javabase.chapter4;

import java.util.Scanner;

public class PriceShow {

	public PriceShow() {
		// TODO Auto-generated constructor stub
	}
	public static  void main(String []args) {
		String name = "";//��Ʒ����
		double price = 0.0;//��Ʒ�۸�
		int proNo = 0;//��Ʒ���
		
		System.out.println("����ϵͳ ->�۸��ѯ");
		System.out.println("-----------------------------");
		System.out.println("��ѡ���ѯ����Ʒ���:");
		System.out.println("1.Java����\t2.�����\t" + "\t3.��ѧ����");
		System.out.println("-----------------------------");
		Scanner input = new Scanner(System.in);
		String answer = "y";
		while("y".equals(answer)) {
			System.out.print("������Ҫ���ҵ���Ʒ���:");
		try {	proNo = input.nextInt();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
			switch (proNo) {
			case 1:
				name = "1.Java����";
				price = 99.0;
				break;
			case 2:
				name = "2.�����";
				price = 299.0;
				break;
			case 3:
				name = "3.��ѧ����";
				price = 99.0;
				break;
			
			}
			System.out.println(name + "\t$" + price +"\n" );
			System.out.println("�Ƿ��������?(y/n)");
			answer = input.next(); 
			
		}
		System.out.println("��ӭʹ�� ~~ see you!");
		input.close();
	}

}
