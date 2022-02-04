package com.leetcode.demo.top_interview_questions_easy;

/**
 * 删除链表的倒数第N个节点 
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/ 
 */
public class Xn2925 {

	public static void main(String[] args) {
		ListNode head = new ListNode();
		head.val = 1;
		ListNode next1 = new ListNode(2);
		head.next = next1;
		ListNode next2 = new ListNode(3);
		next1.next = next2;
//		ListNode next3 = new ListNode(4);
//		next2.next = next3;
//		ListNode next4 = new ListNode(5);
//		next3.next = next4;
//		ListNode next5 = new ListNode(6);
//		next4.next = next5;
		Xn2925 xn2925 = new Xn2925();
		xn2925.printNode(head);
		ListNode noden = xn2925.removeNthFromEnd(head, 2);
		if (noden != null) {
//			System.out.println("noden.val=" + noden.val);
			xn2925.printNode(noden);
		} else {
			System.out.println("noden=null");
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {

		}

		ListNode(int val) {
			this.val = val;
		}
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

	public ListNode removeNthFromEnd(ListNode head, int n) {
//		System.out.println("removeNthFromEnd:head=" + head.val + ",n=" + n);
		ListNode slow = head;
		ListNode fast = head;
		while (n > 0) {
			n--;
			fast = fast.next;
		}
		System.out.println("removeNthFromEnd:fast=" + fast);
		if (fast == null) {
			System.out.println("removeNthFromEnd:head.next=" + head.next);
			return head.next;
		}
		fast = fast.next;
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		System.out.println("removeNthFromEnd:slow=" + slow.val);
		slow.next = slow.next.next;
		return head;
	}
}
