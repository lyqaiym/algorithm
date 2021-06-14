package com.xiaohui.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		int[] temp = new int[arr.length];
		sort(arr, 0, arr.length - 1, temp);
	}

	private static void sort(int[] arr, int left, int right, int[] temp) {
		System.out.println("sort=" + left + ",right=" + right);
		if (left < right) {
			int mid = (left + right) / 2;
			sort(arr, left, mid, temp);// 左边归并排序，使得左子序列有序
			sort(arr, mid + 1, right, temp);// 右边归并排序，使得右子序列有序
			merge(arr, left, mid, right, temp);// 将两个有序子数组合并操作
		}
	}

	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		System.out.println("merge:left=" + left + ",mid=" + mid + ",right=" + right);
		int i = left;
		int j = mid + 1;
		int t = 0;
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		t = 0;
		System.out.print("merge:temp=[");
		while (left <= right) {
			int t1 = t;
			arr[left++] = temp[t++];
			System.out.print(temp[t1] + ",");
		}
		System.out.println("]");
		System.out.println("merge:arr=" + Arrays.toString(arr));
	}
}
