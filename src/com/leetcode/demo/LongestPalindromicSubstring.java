package com.leetcode.demo;

import java.util.ArrayList;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
//		String res = l.longestPalindrome("babad");
		String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattle"
				+ "fiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthat"
				+ "thatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotcons"
				+ "ecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwer"
				+ "toaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisf"
				+ "orusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisr"
				+ "atherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotionto"
				+ "thatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinv"
				+ "ainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		long b = System.currentTimeMillis();
		String res = l.longestPalindrome(str);
		System.out.println("res1=" + res + ",time=" + (System.currentTimeMillis() - b));
		b = System.currentTimeMillis();
		res = l.longestPalindrome2(str);
		System.out.println("res2=" + res + ",time=" + (System.currentTimeMillis() - b));
		res = l.longestPalindrome3(str);
		System.out.println("res3=" + res + ",time=" + (System.currentTimeMillis() - b));
	}

	private int start, end;

	class MidDirection {
		String s;
		int mid;
		int direction;

		MidDirection(String s, int mid, int direction) {
			this.s = s;
			this.mid = mid;
			this.direction = direction;
		}
	}

	public String longestPalindrome(String s1) {
		int start = 0, end = 0;
		ArrayList<MidDirection> mids = new ArrayList<MidDirection>();
		mids.add(new MidDirection(s1, s1.length() / 2, 0));
		while (!mids.isEmpty()) {
			MidDirection midDirection = mids.remove(0);
			String s = midDirection.s;
			int mid = midDirection.mid;
			int direction = midDirection.direction;
			int left = mid - 1, right = mid + 1;
			while (left >= 0 && s.charAt(mid) == s.charAt(left))
				left--;
			while (right < s.length() && s.charAt(mid) == s.charAt(right))
				right++;
			int leftMid = left, rightMid = right;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			if (right - left - 1 > end - start) {
				start = left + 1;
				end = right;
			}
			if (direction <= 0 && leftMid * 2 + 1 > end - start) {
//				expend(s, leftMid, -1);
				mids.add(new MidDirection(s, leftMid, -1));
			}
			if (direction >= 0 && (s.length() - rightMid) * 2 + 1 > end - start) {
//				expend(s, rightMid, 1);
				mids.add(new MidDirection(s, rightMid, 1));
			}
		}
		return s1.substring(start, end);
	}

	public String longestPalindrome4(String s) {
		expend2(s, s.length() / 2, 0);
		return s.substring(start, end);
	}

	private void expend2(String s, int mid, int direction) {
		int left = mid - 1, right = mid + 1;
		while (left >= 0 && s.charAt(mid) == s.charAt(left))
			left--;
		while (right < s.length() && s.charAt(mid) == s.charAt(right))
			right++;
		int leftMid = left, rightMid = right;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if (right - left - 1 > end - start) {
			start = left + 1;
			end = right;
		}
		if (direction <= 0 && leftMid * 2 + 1 > end - start)
			expend2(s, leftMid, -1);
		if (direction >= 0 && (s.length() - rightMid) * 2 + 1 > end - start)
			expend2(s, rightMid, 1);
	}

	public String longestPalindrome3(String s) {
		final int len = s.length();
		if (len < 2) {
			return s;
		}

		int maxLen = 1;
		int begin = 0;
		// dp[i][j] 表示 s[i..j] 是否是回文串
		boolean[][] dp = new boolean[len][len];
		// 初始化：所有长度为 1 的子串都是回文串
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}

		char[] charArray = s.toCharArray();
		// 递推开始
		// 先枚举子串长度
		for (int L = 2; L <= len; L++) {
			// 枚举左边界，左边界的上限设置可以宽松一些
			for (int i = 0; i < len; i++) {
				// 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
				int j = L + i - 1;
				// 如果右边界越界，就可以退出当前循环
				if (j >= len) {
					break;
				}

				if (charArray[i] != charArray[j]) {
					dp[i][j] = false;
				} else {
					if (j - i < 3) {
						dp[i][j] = true;
					} else {
						dp[i][j] = dp[i + 1][j - 1];
					}
				}

				// 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
				if (dp[i][j] && j - i + 1 > maxLen) {
					maxLen = j - i + 1;
					begin = i;
				}
			}
		}
		return s.substring(begin, begin + maxLen);
	}

	public boolean isPalindromic(String s) {
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public String longestPalindrome2(String s) {
		String maxstr = "" + s.charAt(0);
		for (int i = 0; i < s.length(); i++) {
			int m = 1;
			char charA = s.charAt(i);
//			System.out.println("i=" + i + ",charAt=" + charA);
			while (true) {
//				System.out.println("i=" + i + ",m=" + m + ",charAt=" + charA + "----------------");
				String left = "";
				boolean end = true;
				if (i - m >= 0) {
					end = false;
					left = s.substring(i - m, i);
				}
				String right1 = "";
				if ((i + 1 <= s.length() && i + m + 1 <= s.length())) {
					end = false;
					right1 = s.substring(i + 1, i + m + 1);
				}
//				System.out.println("left=" + left + ",right1=" + right1);
				boolean palind = isPalindromic(left + charA + right1);
//				System.out.println("palind1=" + palind);
				if (palind) {
					String hw = left + charA + right1;
					if (hw.length() > maxstr.length()) {
						maxstr = hw;
					}
				} else {
					palind = isPalindromic(left + charA + "");
//					System.out.println("palind2=" + palind);
					if (palind) {
						String hw = left + charA;
						if (hw.length() > maxstr.length()) {
							maxstr = hw;
						}
					}
					palind = isPalindromic("" + charA + right1);
//					System.out.println("palind3=" + palind);
					if (palind) {
						String hw = charA + right1;
						if (hw.length() > maxstr.length()) {
							maxstr = hw;
						}
					}
				}
				if (end) {
					break;
				}
				m++;
			}
		}
		return maxstr;
	}
}
