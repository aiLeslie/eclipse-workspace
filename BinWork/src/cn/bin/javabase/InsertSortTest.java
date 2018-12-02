package cn.bin.javabase;

import java.util.Random;

public class InsertSortTest {
	public static void main(String[] args) {
		int[] numbers = bulidRandomNumbers(10, 100);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ",");
		}
		System.out.println();

		insertionSort(numbers, numbers.length);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ",");
		}
		System.out.println();
	}
	private static void insertionSort(int[] nums, int len) {
		for (int i = 1; i < len; i++) {
			int get = nums[i]; // 获取本次循环向左比较的值
			int previous = i - 1; // 获取本次循环向左比较的值的前一个指引
			while (previous >= 0 && get < nums[previous]) {
				nums[previous + 1] = nums[previous]; // 向右移动
				previous--;
			}
			nums[previous + 1] = get;
		}
	}
	/**
	 * 创建随机数字数组
	 * 
	 * @param len
	 * @param max
	 * @return
	 */
	public static int[] bulidRandomNumbers(int len, int max) {
		if (len <= 0) {
			return null;
		}
		int[] array = new int[len];
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			array[i] = random.nextInt(max);
		}
		return array;
	}
}
