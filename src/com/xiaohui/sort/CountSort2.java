package com.xiaohui.sort;

import java.util.Arrays;

public class CountSort2 {
	public static int[] countSort(int[] arr) {
		int max = arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		int d = max - min;
		int[] countArray = new int[d + 1];
		for (int i = 0; i < arr.length; i++) {
			countArray[arr[i] - min]++;
		}
		System.out.println("countArray1=" + Arrays.toString(countArray));
		for (int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i - 1];
		}
		System.out.println("countArray2=" + Arrays.toString(countArray));
		int[] sortArray = new int[arr.length];
		System.out.println("countSort:max=" + (max + 1) + "," + arr.length);
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println("arr[i] - min]=" + (arr[i] - min) + "," + (countArray[arr[i] - min]));
			System.out.println("arr[" + i + "]=" + arr[i]);
			sortArray[countArray[arr[i] - min] - 1] = arr[i];
			countArray[arr[i] - min]--;
		}
		return sortArray;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 94, 94, 96, 95, 93, 92, 98, 101, 97, 95, 96, 90, 100 };
		int[] sortArray = countSort(array);
		System.out.println(Arrays.toString(array));
		System.out.println("--------------------------");
		System.out.println(Arrays.toString(sortArray));
//		[90, 92, 93, 94, 94, 95, 95, 96, 96, 97, 98, 100, 101]
//		[90, 92, 93, 0, 94, 0, 95, 0, 96, 97, 98, 100, 101]
	}

}
