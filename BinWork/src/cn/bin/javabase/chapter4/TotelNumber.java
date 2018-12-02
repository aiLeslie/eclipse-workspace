package cn.bin.javabase.chapter4;

public class TotelNumber {

	public TotelNumber() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String []args) {
		int sum = 0;
		int num = 1;
		while(num <= 100 ) {
			sum += num;
			num += 2;
			
		}
		System.out.println("100以内旳奇数和为" + sum);
	}
}
