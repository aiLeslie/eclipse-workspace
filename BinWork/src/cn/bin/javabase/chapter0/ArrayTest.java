package cn.bin.javabase.chapter0;

import java.util.Arrays;

public class ArrayTest <T>{
	
	public static void main(String[] args) {

		String[] str1 = {"h","e","l","l","o","h","e","l","l","o"};
		String[] str2 = {"w","o","r","l","d"};
		System.out.println("复制前");
		for (String string : str2) {
			System.out.print(string);
		}
		System.out.println();
		System.out.println("复制后");
		
		str2 = new ArrayTest<String>().arrayCopy(str1, str2);
		for (String string : str2) {
			System.out.print(string);
		}
		
		
	}
	/**注意返回数组引用变量
	 * 因为不返回根本虚拟参数res引用的数组的指针无法赋值给实际参数
	 * 只是仅仅赋给了虚拟参数obj,方法运行完毕出栈*/
	private T[] arrayCopy(T[] res,T[] target) {
		target = Arrays.copyOf(res,target.length);
		//target = Arrays.copyOfRange(res, 0, res.length);
		
		return target;
	}

}
