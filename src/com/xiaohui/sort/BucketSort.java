package com.xiaohui.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {

	public static double[] bucketSort(double[] arr) {
		double max = arr[0];
		double min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		double d = max - min;
		double bucetNum = arr.length;
		ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>();
		for (int i = 0; i < bucetNum; i++) {
			bucketList.add(new LinkedList<Double>());
		}
		for (int i = 0; i < bucetNum; i++) {
			int num = (int) ((arr[i] - min) * (bucetNum - 1) / d);
			System.out.println("num=" + num);
			bucketList.get(num).add(arr[i]);
		}
		for (int i = 0; i < bucketList.size(); i++) {
			Collections.sort(bucketList.get(i));
		}
		double[] sortArray = new double[arr.length];
		int index = 0;
		System.out.println("countSort:max=" + (max + 1) + "," + arr.length);
		for (int i = 0; i < bucketList.size(); i++) {
			LinkedList<Double> element = bucketList.get(i);
			System.out.println("element=" + element.size());
			for (int j = 0; j < element.size(); j++) {
				sortArray[index++] = element.get(j);
			}
		}
		return sortArray;
	}

	public static void main(String[] args) {
		double[] array = new double[] { 4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4, 12, 10.09 };
		double[] sortArray = bucketSort(array);
		System.out.println(Arrays.toString(array));
		System.out.println("--------------------------");
		System.out.println(Arrays.toString(sortArray));
	}

}
