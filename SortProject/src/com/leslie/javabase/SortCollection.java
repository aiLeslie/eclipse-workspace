package com.leslie.javabase;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * ��Ŀ���ƣ�SortProject �����ƣ�SortCollection �������� �����ˣ������ ����ʱ�䣺2018��6��18�� ����4:40:57
 * 
 * @version 1.0
 */
public class SortCollection {
	/**
	 * ���������������
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
	 * ��������������Ԫ�ص�λ��
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
	 * ð�������㷨���������£� �Ƚ����ڵ�Ԫ�أ����ǰһ���Ⱥ�һ���󣬾Ͱ�������������λ�á�
	 * ��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԡ��ⲽ���������Ԫ�ػ����������� ������е�Ԫ���ظ����ϵĲ��裬�������һ����
	 * ����ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚϡ�
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
	 * ��β�������㷨
	 * 
	 * @param A
	 * @param n
	 */
	public static void cocktailSort(int A[], int n) {
		int left = 0; // ��ʼ���߽�
		int right = n - 1;
		while (left < right) {
			for (int i = left; i < right; i++) // ǰ����,�����Ԫ�طŵ�����
			{
				if (A[i] > A[i + 1]) {
					swap(A, i, i + 1);
				}
			}
			right--;
			for (int i = right; i > left; i--) // �����,����СԪ�طŵ�ǰ��
			{
				if (A[i - 1] > A[i]) {
					swap(A, i - 1, i);
				}
			}
			left++;
		}
	}

	/**
	 * ���������㷨���������� : 1.�ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ������� 2.ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ��
	 * 3.�����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ�� 4.�ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ�� 5.����Ԫ�ز��뵽��λ�ú�
	 * 6.�ظ�����2~5
	 * 
	 * @param A
	 * @param n
	 */
	public static void insertionSort(int A[], int n) {
		for (int i = 1; i < n; i++) // ����ץ�˿�������
		{
			int get = A[i]; // ����ץ��һ���˿���
			int j = i - 1; // ���������ϵ�����������õ�
			while (j >= 0 && A[j] > get) // ��ץ�����������ƴ���������бȽ�
			{
				A[j + 1] = A[j]; // ��������Ʊ�ץ�����ƴ󣬾ͽ�������
				j--;
			}
			A[j + 1] = get; // ֱ�������Ʊ�ץ������С(��������)����ץ�����Ʋ��뵽�������ұ�(���Ԫ�ص���Դ���δ�䣬���Բ����������ȶ���)
		}
	}

	/**
	 * ѡ������
	 * 
	 * @param A ���������
	 * @param n ��������鳤��
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
	 * �鲢����
	 * 
	 * @param A ���������
	 * @param l ��߽�
	 * @param r �ұ߽�
	 */
	public static void mergeSort(int A[], int l, int r) {
		// ��߽� > �ұ߽�
		if (l >= r) {
			return;
		}
		// �������߽���е�
		int mid = (l + r) / 2;
		// ���е�Ϊ���Ž�������
		mergeSort(A, l, mid);
		mergeSort(A, mid + 1, r);
		// �������
		merge(A, l, mid, r);

	}

	private static void merge(int A[], int l, int mid, int r) {
		// ������ʱ����(����Ϊ���ұ߽�֮��)
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
