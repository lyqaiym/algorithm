package com.xiaohui.sort;

import java.util.Arrays;

public class CountSort {
	public static int[] countSort(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int[] countArray = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			countArray[arr[i]]++;
		}
		System.out.println("countArray=" + Arrays.toString(countArray));
		int index = 0;
		int[] sortArray = new int[arr.length];
		System.out.println("countSort:max=" + (max + 1) + "," + arr.length);
		for (int i = 0; i < countArray.length; i++) {
			System.out.println("countSort:i1=" + i + ",c=" + countArray[i]);
			for (int j = 0; j < countArray[i]; j++) {
				sortArray[index++] = i;
				System.out.println("countSort:i2=" + i);
			}
		}
		return sortArray;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 4, 4, 6, 5, 3, 2, 8, 11, 7, 5, 6, 0, 10 };
		int[] sortArray = countSort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(sortArray));
	}

}
