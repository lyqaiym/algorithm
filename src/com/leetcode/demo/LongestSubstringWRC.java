package com.leetcode.demo;

/**无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/ */
public class LongestSubstringWRC {

	public static void main(String[] args) {
		LongestSubstringWRC solution = new LongestSubstringWRC();
//		int length = solution.lengthOfLongestSubstring("abcabcbb");
//		int length = solution.lengthOfLongestSubstring("dcbadcba");
		int length = solution.lengthOfLongestSubstring("adcba");
		System.out.println("length=" + length);
	}

	public int lengthOfLongestSubstring(String s) {
		// 记录字符上一次出现的位置
		int[] last = new int[128];
		for (int i = 0; i < 128; i++) {
			last[i] = -1;
		}
		int n = s.length();

		int res = 0;
		int start = 0; // 窗口开始位置
		for (int i = 0; i < n; i++) {
			int index = s.charAt(i);
			System.out.println("index=" + index + "," + s.charAt(i));
			//因为last[index]代表上一次出现的位置，但是字符串内字符不能重复，所以要从上一次出现位置的下一个位置开始
			start = Math.max(start, last[index] + 1);
			System.out.println("start=" + start + "," + last[index] + "," + (i - start + 1));
			res = Math.max(res, i - start + 1);
			last[index] = i;
		}
		for (int i = 0; i < 128; i++) {
			int j = last[i];
			if (j != -1) {
				System.out.println("i=" + i + ",j=" + j);
			}
		}
		return res;
	}
}
