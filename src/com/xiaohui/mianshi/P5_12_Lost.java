package com.xiaohui.mianshi;

public class P5_12_Lost {
	public static void findLost() {
		int[] array = new int[100];
		for (int i = 0; i < array.length; i++) {
			if (i != 44) {
				array[i] = i + 1;
			}
		}
		findLost(array);
	}

	public static int findLost(int[] array) {
		int sum = (1 + 100) * 100 / 2;
		System.out.println("findLost:sum=" + sum);
		int Lost = sum;
		for (int i = 0; i < array.length; i++) {
			Lost = Lost - array[i];
		}
		System.out.println("findLost:Lost=" + Lost);
		return Lost;
	}

	public static void findLost2() {
		int[] array = new int[] { 3, 1, 3, 2, 2, 4, 1 };
		findLost2(array);
	}

	public static int findLost2(int[] array) {
		int Lost = array[0];
		for (int i = 1; i < array.length; i++) {
			Lost = Lost ^ array[i];
		}
		System.out.println("findLost2:Lost=" + Lost);
		return Lost;
	}

	public static void findLost3() {
		int[] array = new int[] { 4, 1, 2, 2, 5, 1, 4, 3 };
		findLost3(array);
	}

	public static int[] findLost3(int[] array) {
		int[] result = new int[2];
		int xorResult = 0;
		for (int i = 0; i < array.length; i++) {
			xorResult ^= array[i];
		}
		System.out.println("findLost3:xorResult=" + xorResult);
		if (xorResult == 0) {
			return null;
		}
		int separator = 1;
		while (0 == (xorResult & separator)) {
			separator <<= 1;
			System.out.println("findLost3:separator=" + separator);
		}
		for (int i = 0; i < array.length; i++) {
			if (0 == (array[i] & separator)) {
				result[0] ^= array[i];
			} else {
				result[1] ^= array[i];
			}
		}
		System.out.println("findLost3:result0=" + result[0] + "," + result[1]);
		return result;
	}

	public static void main(String[] args) {
		findLost3();
	}

}
