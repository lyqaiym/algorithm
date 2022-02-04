package com.leetcode.demo.easy;

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		int x = 1534236469;
		System.out.println(r.reverse(x));
	}

	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			int res10 = res * 10;
			if (res != 0) {
				if (res10 / res != 10) {
					return 0;
				}
			}
			res = res10 + x % 10;
			x = x / 10;
		}
		return res;
	}
}
