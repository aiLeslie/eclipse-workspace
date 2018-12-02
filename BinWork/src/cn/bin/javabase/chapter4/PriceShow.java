package cn.bin.javabase.chapter4;

import java.util.Scanner;

public class PriceShow {

	public PriceShow() {
		// TODO Auto-generated constructor stub
	}
	public static  void main(String []args) {
		String name = "";//产品名称
		double price = 0.0;//产品价格
		int proNo = 0;//产品编号
		
		System.out.println("管理系统 ->价格查询");
		System.out.println("-----------------------------");
		System.out.println("请选择查询的商品编号:");
		System.out.println("1.Java资料\t2.大礼包\t" + "\t3.自学宝典");
		System.out.println("-----------------------------");
		Scanner input = new Scanner(System.in);
		String answer = "y";
		while("y".equals(answer)) {
			System.out.print("请输入要查找的商品编号:");
		try {	proNo = input.nextInt();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
			switch (proNo) {
			case 1:
				name = "1.Java资料";
				price = 99.0;
				break;
			case 2:
				name = "2.大礼包";
				price = 299.0;
				break;
			case 3:
				name = "3.自学宝典";
				price = 99.0;
				break;
			
			}
			System.out.println(name + "\t$" + price +"\n" );
			System.out.println("是否继续查找?(y/n)");
			answer = input.next(); 
			
		}
		System.out.println("欢迎使用 ~~ see you!");
		input.close();
	}

}
