package com.leslie;



public abstract class SortArray<T extends Comparable<T>> implements SortUtil {
	protected int mLeft;
	protected int mRight;
	protected T[] mArray;

	public SortArray() {
		super();
	}

	public SortArray(T[] Array) {
		super();

		array(Array);
	}

	public SortArray<T> array(T[] Array) {
		this.mArray = Array;
		mLeft = 0;
		mRight = mArray.length - 1;
		return this;
	}

	public T[] array() {

		return mArray;
	}

	public boolean mArrayisEmpty() {
		if (mArray == null)
			return true;
		else
			return false;
	}

	public  void swap(T[] A, int i, int j) {

		T temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public void reverse() {
		reverse(0, mArray.length - 1);
	}

	public void reverse(int offset, int to) {
		int mid = (to + offset) / 2;

		for (int i = offset; i <= mid; i++) {
			swap(mArray, i, to--);
		}
	}

	public void printArray() {
		for (int i = 0; i < mArray.length; i++) {
			System.out.print(mArray[i] + ",");
		}
		System.out.println();
	}

}
