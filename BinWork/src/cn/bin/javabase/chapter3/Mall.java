package cn.bin.javabase.chapter3;

import java.io.IOException;
import java.util.Scanner;

public class Mall {

	public Mall() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		String id_status;
		float goods_package = 0;
		float goods_answer = 0;
		float total_cost = 0;
		final double discount = 0.8;
		Scanner input = new Scanner(System.in);

		System.out.print("�Ƿ��ǻ�Ա?(y/n)");
		id_status = input.next();
		try {
			System.out.print("���������۸�:");
			goods_package = input.nextFloat();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.print("������ɰ��۸�:");
			goods_answer = input.nextFloat();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (id_status.compareTo("y") == 0) {
			total_cost += (discount * (goods_answer + goods_package));
		} else {
			total_cost += (goods_answer + goods_package);
		}
		// Runtime.getInstance().exec("cls");//�����������ǲ���

		System.out.println("�ܼ�Ϊ" + total_cost);
		input.close();
	}

}
