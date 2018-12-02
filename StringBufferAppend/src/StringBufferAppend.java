import java.lang.String;
public class StringBufferAppend {

	public static void main(String []args) {
		final int N = 100000;
		long startTime = System.currentTimeMillis();	
	    String str = "*";
	    System.out.print("�ַ�����str�볣���ַ���*�ĵ�ַ�Ƚ�:" /*+ str == "*"*/);
	    System.out.println(str == "*");
	    
	    for(int i = 0 ; i < N ;i++)
	    	str += "*";
	    long endTime = System.currentTimeMillis();
	    long time = endTime - startTime;
	    System.out.println("+=��ʱΪ" + (endTime - startTime) + "����");
	    
	    /**
	     * ʹ��StringBuffer�����ַ���ƴ��
	     */
	    //StringBuffer str1 = new StringBuffer(String.valueOf(str));
	    StringBuffer str2 = new StringBuffer("*");
	    System.out.print("�������str2תΪ�ַ����� *�ĵ�ַ�Ƚ�:");
	    System.out.println("str2.toString() == *" + str2.toString() == "*");
	    
	    System.out.println("�ַ������������?" + str2.toString().equals("*"));
	    
	    startTime = System.currentTimeMillis();	
	    for(int i = 0 ; i < N ;i++)
	   	str2.append("*");
	    endTime = System.currentTimeMillis();
	    time /= (endTime - startTime);
	    System.out.println("StringBuffer��append����ʱΪ" + (endTime - startTime) + "����");
	    
	    System.out.println("+=��ʱ��StringBuffer��append����ʱ��" + time + "��");
	}
	    
}
