package com.leetcode.demo.top_interview_questions_easy;

import com.leetcode.demo.top_interview_questions_easy.Xnnhm6.ListNode;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/
 */
public class Xnnbp2 {

	public static void main(String[] args) {
		Xnnbp2 xn2925 = new Xnnbp2();
		int[] vals1 = new int[] { 1, 2, 3, 4, 5 };
//		int[] vals2 = new int[] { 1, 3, 4 };
//		int[] vals1 = new int[] { 1, 2, 4 };
		int[] vals2 = new int[] { 1, 2, 3 };
		ListNode list1 = xn2925.getListNode(vals1);
		ListNode list2 = xn2925.getListNode(vals2);
		xn2925.printNode(list1);
		xn2925.printNode(list2);
		ListNode noden = xn2925.mergeTwoLists(list1, list2);
		xn2925.printNode(noden);
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

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode list0 = new ListNode(-1);
		ListNode cur = list0;
		while (list1 != null && list2 != null) {
//			System.out.println("mergeTwoLists:cur1=" + list1.val + ",cur2=" + list2.val);
			if (list1.val < list2.val) {
				cur.next = list1;
				list1 = list1.next;
			} else {
				cur.next = list2;
				list2 = list2.next;
			}
//			System.out.println("mergeTwoLists:cur=" + cur.val);
			cur = cur.next;
		}
		if (list1 != null) {
			cur.next = list1;
		}
		if (list2 != null) {
			cur.next = list2;
		}
		return list0.next;
	}
}
