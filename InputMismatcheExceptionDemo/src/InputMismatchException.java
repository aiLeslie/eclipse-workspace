import java.util.Scanner;

public class InputMismatchException {

	public InputMismatchException() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("resource")
	public static void main(String []args) throws LessZeroException {
		Scanner input = new Scanner (System.in);
		System.out.print("(必须是整型数字)请输入您的年龄:");
		int age = Integer.MAX_VALUE;
		try {
			age = input.nextInt();
			
		} catch (Throwable e) {
			e.printStackTrace();
		
		}
		if(age < 0) 
			throw new LessZeroException(age);
			
		System.out.println("age = " + age);
		input.close();
	}
}