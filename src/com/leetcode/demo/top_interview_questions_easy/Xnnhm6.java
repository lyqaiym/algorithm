package com.leetcode.demo.top_interview_questions_easy;

/**
 * 反转链表
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
 */
public class Xnnhm6 {

	public static void main(String[] args) {
		ListNode head = new ListNode();
		head.val = 1;
		ListNode next1 = new ListNode(2);
		head.next = next1;
		ListNode next2 = new ListNode(3);
		next1.next = next2;
		ListNode next3 = new ListNode(4);
		next2.next = next3;
		ListNode next4 = new ListNode(5);
		next3.next = next4;
		ListNode next5 = new ListNode(6);
		next4.next = next5;
		Xnnhm6 xn2925 = new Xnnhm6();
//		xn2925.printNode(head);
		ListNode noden = xn2925.reverseList(head);
		xn2925.printNode(noden);
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

	public ListNode reverseList(ListNode head) {
		ListNode node = head;
		ListNode pre = null;
		while (node != null) {
//			System.out.println("reverseList=" + node.val);
			ListNode next = node.next;
			if (next == null) {
				head = node;
			}
//			if (pre != null) {
//				System.out.println("reverseList:pre=" + pre.val);
//			}
			node.next = pre;
//			System.out.println("reverseList=" + node.val + ",next1=" + node.next);
			pre = node;
			node = next;
//			if (node != null) {
//				System.out.println("reverseList=" + node.val + ",next2=" + node.next);
//			}
		}
		return pre;
	}
}
