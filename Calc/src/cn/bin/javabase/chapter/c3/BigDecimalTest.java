package cn.bin.javabase.chapter.c3;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
		showDistinction();
		showBigDecimalConstructor();
		shoBigDecimalCalc();
	}
	private static void showDistinction() {
		double num1 = 0.1;
		BigDecimal num2 = new BigDecimal("0.1");
		
		for(int i = 0; i < 9; i++) {
			num1 += 0.1;
			num2 = num2.add(new BigDecimal("0.1"));
		}
		System.out.println("double����num��Ϊ" + num1);
		System.out.println("BigDecimal����num��Ϊ" + num2);

	}
	private static void showBigDecimalConstructor() {
		BigDecimal num1 = new BigDecimal("0.1");
		BigDecimal num2 = new BigDecimal(0.1f);
		BigDecimal num3 = new BigDecimal(0.1);
		System.out.println("֤��ʹ�ò�ͬ���췽��,ֵҲ��һ��");
		System.out.println("ʹ��String�͹��췽�� - " + num1);
		System.out.println("ʹ��float�͹��췽�� - " + num2);
		System.out.println("ʹ��double�͹��췽�� - " + num3);
		System.out.println("֤��ʹ���β�ΪString�͹��췽��,���Ӿ���׼ȷ��");
	}
	private static void shoBigDecimalCalc() {
		BigDecimal num1 = new BigDecimal("16");
		System.out.println("16 + 4 = " + num1.add(new BigDecimal(4)));
		System.out.println("16 - 4 = " + num1.subtract(new BigDecimal(4)));
		System.out.println("16 * 4 = " + num1.multiply(new BigDecimal(4)));
		System.out.println("16 / 4 = " + num1.divide(new BigDecimal(4)));
		System.out.println("16 % 4 = " + num1.remainder(new BigDecimal(4)));
		
		
	}
	

}
