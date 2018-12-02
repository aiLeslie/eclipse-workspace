package cn.bin.javabase.chapter0;

public class FatherAndSonTest {

	
	public static void main(String[] args) {
		
		Father fa = new Son();
		
		System.out.println(((Son)fa).age);
//		son.print();
	}

}
