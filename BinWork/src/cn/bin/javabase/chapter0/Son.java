package cn.bin.javabase.chapter0;

public class Son extends Father{
	public int number;
	public int age;

	public Son() {
		this.age = 10;
	}
	public static void main(String[] args) {
		System.out.println();
		
		
	}
	
	@Override
	public void print() {
		System.out.print("调用父类方法:");
		super.print();
		System.out.print("调用我自己方法:");
		System.out.println("i am son");
	}
}
