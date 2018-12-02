import java.util.Scanner;
public  class Num {
	public static boolean isDigit = false;//来判定字符串是否为纯数字
	public  static String strTest;//测试字符串
	public static void main(String[] args) {
		
		inputStr();
    	isDigit(strTest);
		
	}
	
	public static boolean isDigit(String strTest){//来判定字符串是否为纯数字的静态方法
		for(int i = 0 ; i <strTest.length() ; i ++)
		{
			if(!Character.isDigit(strTest.charAt(i))/*!(strTest.charAt(i) >= '0' && strTest.charAt(i) <= '9')*/){
				isDigit = false;
				System.out.println("该字符串不为纯数字");
				return isDigit ;
			}
		}
		isDigit = true;
		System.out.println("该字符串是纯数字");			
		return isDigit;		
	}
	
	public static void inputStr(){
		System.out.print("请输入字符串:");
		Scanner scanner = new Scanner(System.in);
		strTest = scanner.next();
		scanner.close();
	}
	
	public Num(){
		inputStr();
    	isDigit(strTest);
	}
	
   
}
