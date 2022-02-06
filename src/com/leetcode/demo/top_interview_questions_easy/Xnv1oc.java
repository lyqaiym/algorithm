package com.leetcode.demo.top_interview_questions_easy;

import java.util.ArrayList;

/**
 * 回文链表
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
 */
public class Xnv1oc {

	public static void main(String[] args) {
		Xnv1oc xn2925 = new Xnv1oc();
		int[] vals1 = new int[] { 1, 2, 3, 5, 2, 1 };
		ListNode list1 = xn2925.getListNode(vals1);
		int[] vals2 = new int[] { 1, 2, 3, 2, 1 };
		ListNode list2 = xn2925.getListNode(vals2);
		xn2925.printNode(list1);
		xn2925.printNode(list2);
		boolean palin1 = xn2925.isPalindrome(list1);
		System.out.println("getListNode:palin1=" + palin1);
		boolean palin2 = xn2925.isPalindrome(list2);
		System.out.println("getListNode:palin2=" + palin2);
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode fast = head;
		ListNode slow = head;
		ListNode pre = null;
		ListNode next;
		// 快慢指针
		while (fast != null && fast.next != null) {
//			System.out.println("getListNode:fast1=" + fast + ",slow1=" + slow);
			// 快的走两步
			fast = fast.next.next;
			// 慢的走一步
			next = slow.next;
			// 慢的倒排
			slow.next = pre;
			// 慢的前一个
			pre = slow;
			slow = next;
//			System.out.println("getListNode:fast2=" + fast + ",slow2=" + slow);
		}
		System.out.println("getListNode:fast3=" + fast + ",slow3=" + slow);
		ListNode left = pre;
		ListNode right;
		// 快的走到头了。是偶数个，否则是奇数个
		if (fast == null) {
			right = slow;
		} else {
			right = slow.next;
		}
//		System.out.println("getListNode:left=" + left + ",right=" + right);
		while (right != null) {
			if (right.val == left.val) {
				left = left.next;
				right = right.next;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isPalindrome2(ListNode head) {
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		int size = list.size();
		System.out.println("isPalindrome:size=" + size);
		for (int i = 0; i < size / 2; i++) {
			ListNode left = list.get(i);
			ListNode right = list.get(size - 1 - i);
			System.out.println("isPalindrome:left=" + left + "," + right);
			if (left.val != right.val) {
				return false;
			}
		}
		return true;
	}

	private ListNode getListNode(int[] vals) {
		ListNode head = null;
		ListNode pre = null;
		if (vals != null) {
			for (int i = 0; i < vals.length; i++) {
				ListNode node = new ListNode();
				node.val = vals[i];
//				System.out.println("getListNode:val=" + node.val);
				if (head == null) {
					head = node;
				}
				if (pre != null) {
					pre.next = node;
//					System.out.println("getListNode:pre.val=" + pre.val + ",next=" + node.val);
				}
				pre = node;
			}
		}
		return head;
	}

	public void printNode(ListNode head) {
		ListNode node = head;
		StringBuilder sb = new StringBuilder("[");
		while (node != null) {
			sb.append(node.val + ",");
//			System.out.println("printNode=" + node.val);
			node = node.next;
		}
		if (sb.toString().endsWith(",")) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		System.out.println("printNode=" + sb);
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {

		}

		ListNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "val=" + val;
		}
	}
}
