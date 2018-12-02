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
		System.out.println("double类型num和为" + num1);
		System.out.println("BigDecimal类型num和为" + num2);

	}
	private static void showBigDecimalConstructor() {
		BigDecimal num1 = new BigDecimal("0.1");
		BigDecimal num2 = new BigDecimal(0.1f);
		BigDecimal num3 = new BigDecimal(0.1);
		System.out.println("证明使用不同构造方法,值也不一样");
		System.out.println("使用String型构造方法 - " + num1);
		System.out.println("使用float型构造方法 - " + num2);
		System.out.println("使用double型构造方法 - " + num3);
		System.out.println("证明使用形参为String型构造方法,更加具有准确性");
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
