import java.lang.String;
public class StringBufferAppend {

	public static void main(String []args) {
		final int N = 100000;
		long startTime = System.currentTimeMillis();	
	    String str = "*";
	    System.out.print("字符串型str与常量字符串*的地址比较:" /*+ str == "*"*/);
	    System.out.println(str == "*");
	    
	    for(int i = 0 ; i < N ;i++)
	    	str += "*";
	    long endTime = System.currentTimeMillis();
	    long time = endTime - startTime;
	    System.out.println("+=用时为" + (endTime - startTime) + "毫秒");
	    
	    /**
	     * 使用StringBuffer进行字符串拼接
	     */
	    //StringBuffer str1 = new StringBuffer(String.valueOf(str));
	    StringBuffer str2 = new StringBuffer("*");
	    System.out.print("带缓存的str2转为字符串与 *的地址比较:");
	    System.out.println("str2.toString() == *" + str2.toString() == "*");
	    
	    System.out.println("字符串内容相等吗?" + str2.toString().equals("*"));
	    
	    startTime = System.currentTimeMillis();	
	    for(int i = 0 ; i < N ;i++)
	   	str2.append("*");
	    endTime = System.currentTimeMillis();
	    time /= (endTime - startTime);
	    System.out.println("StringBuffer的append的用时为" + (endTime - startTime) + "毫秒");
	    
	    System.out.println("+=用时是StringBuffer的append的用时的" + time + "倍");
	}
	    
}
