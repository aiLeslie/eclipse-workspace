package cn.bin.javabase.chapter0;

public class Outer {

	public int id = 1;
	private String name = "Àîçâ±ó";
	public Inner inner = new Inner();

	public Inner newInnerInstance() {
		return new Inner();
	}

	public class Inner {
		public Inner() {
			this.toString();
		}

		private int age = 20;
		public String sex = "male";

		public void printName() {
			System.out.println(Outer.this.name);
		}

		@Override
		public String toString() {
			return "age = " + age + "sex = " + this.sex;
		}
	}



}
