package cn.bin.javabase.chapter0;

import java.util.Arrays;

public class ArrayTest <T>{
	
	public static void main(String[] args) {

		String[] str1 = {"h","e","l","l","o","h","e","l","l","o"};
		String[] str2 = {"w","o","r","l","d"};
		System.out.println("����ǰ");
		for (String string : str2) {
			System.out.print(string);
		}
		System.out.println();
		System.out.println("���ƺ�");
		
		str2 = new ArrayTest<String>().arrayCopy(str1, str2);
		for (String string : str2) {
			System.out.print(string);
		}
		
		
	}
	/**ע�ⷵ���������ñ���
	 * ��Ϊ�����ظ����������res���õ������ָ���޷���ֵ��ʵ�ʲ���
	 * ֻ�ǽ����������������obj,����������ϳ�ջ*/
	private T[] arrayCopy(T[] res,T[] target) {
		target = Arrays.copyOf(res,target.length);
		//target = Arrays.copyOfRange(res, 0, res.length);
		
		return target;
	}

}
