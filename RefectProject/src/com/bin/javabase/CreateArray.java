package com.bin.javabase;

import java.lang.reflect.Array;

public class CreateArray {

	public static void main(String[] args) {
		int[][] array = (int[][]) Array.newInstance(int.class, new int[] { 3, 3 });
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = (i + 1) * (j + 1);
			}
		}
		for (int i = 0; i < array.length; i++) {
			
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();

		}
	}

}
