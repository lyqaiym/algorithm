package com.leetcode.demo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数 https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 */
public class FractionToRecurring {

	public static void main(String[] args) {
		FractionToRecurring fractionToRecurring = new FractionToRecurring();
		int numerator = 4;
		int denominator = 333;
//		int numerator = 1;
//		int denominator = 19;
		String decimal = fractionToRecurring.fractionToDecimal(numerator, denominator);
		System.out.println("decimal=" + decimal);
	}

	public String fractionToDecimal(int numerator, int denominator) {
		// 转 long 计算，防止溢出
		long a = numerator, b = denominator;
		// 如果本身能够整除，直接返回计算结果
		if (a % b == 0)
			return String.valueOf(a / b);
		StringBuilder sb = new StringBuilder();
		// 如果其一为负数，先追加负号
		if (a * b < 0)
			sb.append('-');
		a = Math.abs(a);
		b = Math.abs(b);
		// 计算小数点前的部分，并将余数赋值给 a
		sb.append(String.valueOf(a / b) + ".");
		a %= b;
		Map<Long, Integer> map = new HashMap<>();
		while (a != 0) {
			// 记录当前余数所在答案的位置，并继续模拟除法运算
			map.put(a, sb.length());
			System.out.println("a=" + a + ",sb=" + sb);
			a *= 10;
			sb.append(a / b);
			System.out.println("a=" + a + ",sb=" + sb);
			System.out.println("map=" + map.size());
			a %= b;
			// 如果当前余数之前出现过，则将 [出现位置 到 当前位置] 的部分抠出来（循环小数部分）
			if (map.containsKey(a)) {
				int u = map.get(a);
				return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
			}
		}
		return sb.toString();
	}

	public String fractionToDecimal3(int numerator, int denominator) {
		long numeratorLong = (long) numerator;
		long denominatorLong = (long) denominator;
		if (numeratorLong % denominatorLong == 0) {
			return String.valueOf(numeratorLong / denominatorLong);
		}

		StringBuffer sb = new StringBuffer();
		if (numeratorLong < 0 ^ denominatorLong < 0) {
			sb.append('-');
		}

		// 整数部分
		numeratorLong = Math.abs(numeratorLong);
		denominatorLong = Math.abs(denominatorLong);
		long integerPart = numeratorLong / denominatorLong;
		sb.append(integerPart);
		sb.append('.');

		// 小数部分
		StringBuffer fractionPart = new StringBuffer();
		Map<Long, Integer> remainderIndexMap = new HashMap<Long, Integer>();
		long remainder = numeratorLong % denominatorLong;
		int index = 0;
		while (remainder != 0 && !remainderIndexMap.containsKey(remainder)) {
			remainderIndexMap.put(remainder, index);
			remainder *= 10;
			fractionPart.append(remainder / denominatorLong);
			System.out.println("remainder=" + remainder);
			remainder %= denominatorLong;
			index++;
		}
		if (remainder != 0) { // 有循环节
			int insertIndex = remainderIndexMap.get(remainder);
			fractionPart.insert(insertIndex, '(');
			fractionPart.append(')');
		}
		sb.append(fractionPart.toString());

		return sb.toString();
	}

	public String fractionToDecimal2(int numerator, int denominator) {
		int a = numerator / denominator;
		if (numerator % denominator == 0) {
			return a + "";
		} else {
			BigDecimal d1 = new BigDecimal(numerator + "000000000000000");
//			BigDecimal d1 = new BigDecimal(numerator);
			BigDecimal d2 = new BigDecimal(denominator + "000000000000000");
			System.out.println("d1=" + d1 + ",d2=" + d2);
			BigDecimal d3 = d1.divide(d2, MathContext.DECIMAL128);
			String str = ("" + d3);
			System.out.println("d3=" + d3);
			int index = str.indexOf(".");
			System.out.println("d3=" + d3 + ",index=" + index);
			str = str.substring(index + 1);
			while (str.endsWith("0")) {
				str = str.substring(0, str.length() - 1);
			}
			System.out.println("str=" + str);
//			if (str.length() == 1) {
//				return a + "." + str;
//			}
			String finds = "";
			int lastfind = 0;
			int start = 0;
			while (start < str.length()) {
				int num = 1;
				while (num < str.length()) {
					String cf1 = "";
					for (int i = start; i < start + num && i < str.length(); i++) {
						cf1 += "" + str.charAt(i);
					}
					System.out.println("cf1=" + cf1);
					int find = 0;
					for (int i = start + num; i < str.length(); i += cf1.length()) {
						String cf2 = "";
						int j;
						for (j = i; j < i + num && j < str.length(); j++) {
							cf2 += "" + str.charAt(j);
						}
						if (cf1.equals(cf2)) {
							find++;
						} else {
//							find = 0;
							break;
						}
						System.out.println("i=" + i + ",cf2=" + cf2);
					}
					System.out.println("num=" + num + ",find=" + find);
					if (find > lastfind) {
						lastfind = find;
						finds = cf1;
					}
					num++;
				}
				if (lastfind == 0) {
					System.out.println("start2=" + start);
					start++;
				} else {
					break;
				}
			}
			String before = str.substring(0, start);
			System.out.println("start=" + start + "," + before);
			if (lastfind == 0) {
				return a + "." + str;
			}
			return a + "." + before + "(" + finds + ")";
		}
	}
}
