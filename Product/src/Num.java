import java.util.Scanner;
public  class Num {
	public static boolean isDigit = false;//���ж��ַ����Ƿ�Ϊ������
	public  static String strTest;//�����ַ���
	public static void main(String[] args) {
		
		inputStr();
    	isDigit(strTest);
		
	}
	
	public static boolean isDigit(String strTest){//���ж��ַ����Ƿ�Ϊ�����ֵľ�̬����
		for(int i = 0 ; i <strTest.length() ; i ++)
		{
			if(!Character.isDigit(strTest.charAt(i))/*!(strTest.charAt(i) >= '0' && strTest.charAt(i) <= '9')*/){
				isDigit = false;
				System.out.println("���ַ�����Ϊ������");
				return isDigit ;
			}
		}
		isDigit = true;
		System.out.println("���ַ����Ǵ�����");			
		return isDigit;		
	}
	
	public static void inputStr(){
		System.out.print("�������ַ���:");
		Scanner scanner = new Scanner(System.in);
		strTest = scanner.next();
		scanner.close();
	}
	
	public Num(){
		inputStr();
    	isDigit(strTest);
	}
	
   
}
