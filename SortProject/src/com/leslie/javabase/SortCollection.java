package com.leslie.javabase;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * 项目名称：SortProject 类名称：SortCollection 类描述： 创建人：李玮斌 创建时间：2018年6月18日 下午4:40:57
 * 
 * @version 1.0
 */
public class SortCollection {
	/**
	 * 创建随机数字数组
	 * 
	 * @param len
	 * @param max
	 * @return
	 */
	public static Integer[] bulidRandomNumbers(int len, int max) {
		if (len <= 0) {
			return null;
		}
		Integer[] array = new Integer[len];
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			array[i] = random.nextInt(max);
		}
		return array;
	}

	/**
	 * 交换数组中两个元素的位置
	 * 
	 * @param A
	 * @param i
	 * @param j
	 */
	public static void swap(int A[], int i, int j) {

		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void printArray(Integer A[]) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ",");
		}
		System.out.println();
	}

	/**
	 * 冒泡排序算法的运作如下： 比较相邻的元素，如果前一个比后一个大，就把它们两个调换位置。
	 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。 针对所有的元素重复以上的步骤，除了最后一个。
	 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	 * 
	 * @param A
	 * @param n
	 */
	public static void bubbleSort(int A[], int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (A[j] > A[j + 1]) {
					swap(A, j, j + 1);
				}
			}
		}
	}

	/**
	 * 鸡尾酒排序算法
	 * 
	 * @param A
	 * @param n
	 */
	public static void cocktailSort(int A[], int n) {
		int left = 0; // 初始化边界
		int right = n - 1;
		while (left < right) {
			for (int i = left; i < right; i++) // 前半轮,将最大元素放到后面
			{
				if (A[i] > A[i + 1]) {
					swap(A, i, i + 1);
				}
			}
			right--;
			for (int i = right; i > left; i--) // 后半轮,将最小元素放到前面
			{
				if (A[i - 1] > A[i]) {
					swap(A, i - 1, i);
				}
			}
			left++;
		}
	}

	/**
	 * 插入排序算法的运作如下 : 1.从第一个元素开始，该元素可以认为已经被排序 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
	 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置 5.将新元素插入到该位置后
	 * 6.重复步骤2~5
	 * 
	 * @param A
	 * @param n
	 */
	public static void insertionSort(int A[], int n) {
		for (int i = 1; i < n; i++) // 类似抓扑克牌排序
		{
			int get = A[i]; // 右手抓到一张扑克牌
			int j = i - 1; // 拿在左手上的牌总是排序好的
			while (j >= 0 && A[j] > get) // 将抓到的牌与手牌从右向左进行比较
			{
				A[j + 1] = A[j]; // 如果该手牌比抓到的牌大，就将其右移
				j--;
			}
			A[j + 1] = get; // 直到该手牌比抓到的牌小(或二者相等)，将抓到的牌插入到该手牌右边(相等元素的相对次序未变，所以插入排序是稳定的)
		}
	}

	/**
	 * 选择排序
	 * 
	 * @param A 排序的数组
	 * @param n 排序的数组长度
	 */
	public static void selectionSort(int A[], int n) {
		int index = -1;
		int min = -1;
		for (int i = 0; i < n - 1; i++) {
			index = i;
			min = A[index];
			for (int j = i; j < n; j++) {
				if (min > A[j]) {
					min = A[j];
					index = j;
				}
			}
			swap(A, index, i);
		}
	}

	/**
	 * 归并排序
	 * 
	 * @param A 排序的数组
	 * @param l 左边界
	 * @param r 右边界
	 */
	public static void mergeSort(int A[], int l, int r) {
		// 左边界 > 右边界
		if (l >= r) {
			return;
		}
		// 计算两边界的中点
		int mid = (l + r) / 2;
		// 以中点为两排进行排序
		mergeSort(A, l, mid);
		mergeSort(A, mid + 1, r);
		// 排序操作
		merge(A, l, mid, r);

	}

	private static void merge(int A[], int l, int mid, int r) {
		// 复制临时数组(长度为左右边界之差)
		int[] temp = Arrays.copyOf(A, r - l + 1);

		for (int i = 0; i < temp.length; i++) {
			temp[i] = A[i + l];
		}

		int i = l, j = mid + 1;

		for (int k = l; k <= r; k++) {
			if (i > mid) {
				A[k] = temp[j - l];
				j++;
			} else if (j > r) {
				A[k] = temp[i - l];
				i++;
			} else if (temp[i - l] < temp[j - l]) {
				A[k] = temp[i - l];
				i++;
			} else {
				A[k] = temp[j - l];
				j++;
			}
		}

	}

	public static void main(String[] args) {
		Integer[] numbers = bulidRandomNumbers(3, 10);
		printArray(numbers);
		

		printArray(numbers);

//		cocktailSort(numbers, numbers.length);
//		insertionSort(numbers, numbers.length);

	}
}
