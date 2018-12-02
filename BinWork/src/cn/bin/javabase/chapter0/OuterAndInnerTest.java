package cn.bin.javabase.chapter0;

public class OuterAndInnerTest {

	public static void main(String[] args) {
		Outer outter = new Outer();
		System.out.println("id:" + outter.id);
		System.out.println("sex:" + outter.newInnerInstance().sex);
		//System.out.print("name:");  outter.new Inner().printName();
		System.out.println(outter.inner.toString());
		

	}
}
