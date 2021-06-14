package com.xiaohui.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class QuitSort {
	public static void println(String msg) {
		System.out.println(msg);
	}

	public static void quitSortStack(int[] arr, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
		Map<String, Integer> rootParam = new HashMap<String, Integer>();
		rootParam.put("startIndex", startIndex);
		rootParam.put("endIndex", endIndex);
		quickSortStack.push(rootParam);
		while (!quickSortStack.isEmpty()) {
			Map<String, Integer> param = quickSortStack.pop();
			int povotIndex = partitionDan(arr, param.get("startIndex"), param.get("endIndex"));
			if (param.get("startIndex") < povotIndex - 1) {
				Map<String, Integer> leftParam = new HashMap<String, Integer>();
				leftParam.put("startIndex", param.get("startIndex"));
				leftParam.put("endIndex", povotIndex - 1);
				quickSortStack.push(leftParam);
			}
			if (povotIndex + 1 < param.get("endIndex")) {
				Map<String, Integer> rightParam = new HashMap<String, Integer>();
				rightParam.put("startIndex", povotIndex + 1);
				rightParam.put("endIndex", param.get("endIndex"));
				quickSortStack.push(rightParam);
			}
//			println("quickSortStack=" + quickSortStack.size());
		}
	}

	public static void quitSortDan(int[] arr, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int povotIndex = partitionDan(arr, startIndex, endIndex);
//		int povotIndex = partitionShuang(arr, startIndex, endIndex);
//		println("quitSortDan:povotIndex=" + povotIndex);
		quitSortDan(arr, startIndex, povotIndex - 1);
		quitSortDan(arr, povotIndex + 1, endIndex);
	}

	public static void quitSortShuang(int[] arr, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int povotIndex = partitionShuang(arr, startIndex, endIndex);
//		println("povotIndex=" + povotIndex);
		quitSortShuang(arr, startIndex, povotIndex - 1);
		quitSortShuang(arr, povotIndex + 1, endIndex);
	}

	public static int partitionDan(int[] arr, int startIndex, int endIndex) {
		int pivot = arr[startIndex];
//		println("partitionDan:pivot=" + pivot);
		int mart = startIndex;
		for (int i = startIndex + 1; i <= endIndex; i++) {
			if (arr[i] < pivot) {
				mart++;
				int p = arr[mart];
//				println("partitionDan:arr[" + i + "]=" + arr[i]);
				arr[mart] = arr[i];
				arr[i] = p;
			}
		}
		arr[startIndex] = arr[mart];
		arr[mart] = pivot;
//		println(Arrays.toString(arr));
		return mart;
	}

	public static int partitionShuang(int[] arr, int startIndex, int endIndex) {
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		println("partitionShuang:l=" + left + ",r=" + right);
		while (left != right) {
			while (left < right && arr[right] > pivot) {
				right--;
			}
			while (left < right && arr[left] <= pivot) {
				left++;
			}
			if (left < right) {
				int p = arr[left];
				println("partitionShuang:arr[" + left + "]=" + arr[left] + ",arr[" + right + "]=" + arr[right]);
				arr[left] = arr[right];
				arr[right] = p;
				println(Arrays.toString(arr));
			}
		}
		arr[startIndex] = arr[left];
		arr[left] = pivot;
		return left;
	}

	public static void main(String[] args) {
//		int[] arr = new int[] { 4, 4, 6, 5, 3, 2, 1, 8 };
//		int[] arr = new int[] { 4, 3, 7, 5, 6, 2, 8, 1 };
		int[] arr = new int[22222];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
//			arr[i] = 1 + r.nextInt(100);
			arr[i] = i;
		}
//		System.out.println(Arrays.toString(arr));
		long before = System.currentTimeMillis();
		quitSortDan(arr, 0, arr.length - 1);
		println("time1=" + (System.currentTimeMillis() - before));
		before = System.currentTimeMillis();
		quitSortStack(arr, 0, arr.length - 1);
		println("time2=" + (System.currentTimeMillis() - before));
//		before = System.currentTimeMillis();
//		quitSortShuang(arr, 0, arr.length - 1);
//		println("time3=" + (System.currentTimeMillis() - before));
//		println(Arrays.toString(arr));
	}

}
