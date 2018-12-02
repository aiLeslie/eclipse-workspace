package com.leslie;

import java.util.Arrays;

import com.leslie.javabase.SortCollection;


public class MergeSortUtil<T extends Comparable<T>> extends SortArray<T> {

	public MergeSortUtil() {
		super();

	}

	public MergeSortUtil(T[] Array) {
		super(Array);

	}

	@Override
	public void sort() {

//		mergeSort(mLeft, mRight);
		MyMergeSort();

	}
	
	private void MyMergeSort() {
		int len = mArray.length;
		for (int size = 2; size < len; size *= 2) {
			int n = len / size;
			for (int g = 0; g < n; g++) {
				merge(g * size, (2 * g + 1) * size / 2, (g + 1) * size - 1);
			}
		}
	}

	@SuppressWarnings("unused")
	private void mergeSort(int left, int right) {
		if (left == right) {
			return;
		}

		int mid = (left + right) / 2;

		mergeSort(left, mid);
		mergeSort(mid + 1, right);

		if (mArray[mid].compareTo(mArray[mid + 1]) > 0)
			merge(left, mid, right);
	}

	private void merge(int left, int mid, int right) {
		T[] temp = Arrays.copyOfRange(mArray, left, right + 1);

		int k = left, i = left, j = mid + 1;

		for (; k <= right; k++) {
			if (i > mid) {
				mArray[k] = temp[j - left];
				j++;
			} else if (j > right) {
				mArray[k] = temp[i - left];
				i++;
			} else if (temp[i - left].compareTo(temp[j - left]) < 0) {
				mArray[k] = temp[i - left];
				i++;
			} else {
				mArray[k] = temp[j - left];
				j++;
			}
		}

	}

	public static void main(String[] args) {
		Integer[] numbers = SortCollection.bulidRandomNumbers(6, 10);

		SortArray<Integer> array = new MergeSortUtil<Integer>().array(numbers);

		array.printArray();

		array.sort();

		array.printArray();
		
		array.reverse();

		array.printArray();

		Arrays.sort(array.array(), null);
		
		System.out.println(Math.log10(10));
	}

}
