package com.leetcode.demo.top_interview_questions_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Fizz Buzz
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xngt85/
 */
public class Xngt85 {

	public static void main(String[] args) {
		Xngt85 xngt85 = new Xngt85();
		List<String> list = xngt85.fizzBuzz(15);
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.print(s + ",");
		}
		System.out.println();
	}

	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < n + 1; i++) {
			if (i % 15 == 0) {
				list.add("FizzBuzz");
			} else if (i % 3 == 0) {
				list.add("Fizz");
			} else if (i % 5 == 0) {
				list.add("Buzz");
			} else {
				list.add("" + i);
			}
		}
		return list;
	}

	public List<String> fizzBuzz2(int n) {
		String[] ss = new String[n];
		for (int i = 0; i < n; i++) {
			int m = i + 1;
			if (m % 3 == 0) {
				if (m % 5 == 0) {
					ss[i] = "FizzBuzz";
					continue;
				} else {
					ss[i] = "Fizz";
					continue;
				}
			} else {
				if (m % 5 == 0) {
					ss[i] = "Buzz";
					continue;
				}
			}
			ss[i] = "" + m;
		}
		List<String> list = Arrays.asList(ss);
		return list;
	}
}
