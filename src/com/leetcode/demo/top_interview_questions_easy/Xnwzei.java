package com.leetcode.demo.top_interview_questions_easy;

/**
 * 环形链表
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/
 */
public class Xnwzei {

	public static void main(String[] args) {
		Xnwzei xn2925 = new Xnwzei();
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
		next5.next = next2;
//		xn2925.printNode(head);
		boolean palin1 = xn2925.hasCycle(head);
		System.out.println("hasCycle:palin1=" + palin1);
	}

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public void printNode(ListNode head) {
		ListNode node = head;
		StringBuilder sb = new StringBuilder("[");
		while (node != null) {
			sb.append(node.val + ",");
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
