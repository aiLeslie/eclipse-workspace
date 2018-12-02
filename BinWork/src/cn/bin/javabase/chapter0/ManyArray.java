package cn.bin.javabase.chapter0;

public class ManyArray {
	public static void main(String[] args) {

		test();
		integerArray();
		
	}
	private static void test() {
		Double[][] array = new Double[15][];
		for(int i = 0; i < array.length;i++) {
			array[i] = new Double[i];
		}
		for(Double []is : array) {
			for(Double i : is) {
				System.out.print(i);
			}
			System.out.println();
		}
		
	}

	public static void myStrArray() {
		String[] []array = new String[5][5];
		/**������ά����*/
		for (String[] is : array) {
			for (String i : is) {
				System.out.println(i);
			}
			
			
		}
		/**�ж����ñ�������ֵ�Ȳ�������Ԫ�صĵ�ַ,���ֲ�һ��*/
		System.out.println(array);
		System.out.println( array[0][0].hashCode());
		//System.out.println(array == array[0][0].hashCode());//����ֱ�ӱȽ�,������
	}
	private static void integerArray() {
		int [][]array = new int[100][100];
		for(int i = 0; i < array.length;i ++) {
			for(int j = 0 ; j < array[0].length; j++) {
				array[i][j] = (i + 1) * (j + 1);
			}
		}
		System.out.println("~�ٰٳ˷���~");
		for (int[] is : array) {
			for (int i : is) {
				System.out.printf("%-5d ",i);
			}
			System.out.println();
		}
		
	}
}
