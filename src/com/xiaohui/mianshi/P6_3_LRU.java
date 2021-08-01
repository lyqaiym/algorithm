package com.xiaohui.mianshi;

import java.util.HashMap;

public class P6_3_LRU {

	public static void main(String[] args) {
		LRUCache lCache = new LRUCache(5);
		lCache.put("001", "用户1信息");
		lCache.put("002", "用户2信息");
		lCache.put("003", "用户3信息");
		lCache.put("004", "用户4信息");
		lCache.put("005", "用户5信息");
		System.out.println("002=" + lCache.get("002"));
		lCache.put("004", "用户2信息更新");
		lCache.put("006", "用户4信息");
		System.out.println("001=" + lCache.get("001"));
		System.out.println("006=" + lCache.get("006"));
	}

	static class LRUCache {
		Node head;
		Node end;
		int limit;
		private HashMap<String, Node> hashMap;

		public LRUCache(int limit) {
			this.limit = limit;
			hashMap = new HashMap<String, Node>();
		}

		String get(String key) {
			Node node = hashMap.get(key);
			if (node == null) {
				System.out.println("get:null:key=" + key);
				return null;
			}
			refreshNode(node);
			return node.value;
		}

		void put(String key, String value) {
			Node node = hashMap.get(key);
			if (node == null) {
				if (hashMap.size() >= limit) {
					String oldKey = removeNode(head);
					System.out.println("put:oldKey=" + oldKey + ",s1=" + hashMap.size());
					hashMap.remove(oldKey);
					System.out.println("put:s2=" + hashMap.size());
				}
				node = new Node(key, value);
				addNode(node);
				hashMap.put(key, node);
			} else {
				node.value = value;
				refreshNode(node);
			}
		}

		void remove(String key) {
			Node node = hashMap.get(key);
			refreshNode(node);
			hashMap.remove(key);
		}

		private void refreshNode(Node node) {
			if (node == end) {
				return;
			}
			removeNode(node);
			addNode(node);
		}

		private String removeNode(Node node) {
			if (node == head && node == end) {
				head = null;
				end = null;
			} else if (node == end) {
				// 移除尾节点
				end = end.pre;
				end.next = null;
			} else if (node == head) {
				// 移除头节点
				head = head.next;
				head.pre = null;
			} else {
				node.pre.next = node.next;
				node.next.pre = node.pre;
			}
			return node.key;
		}

		private void addNode(Node node) {
			if (end != null) {
				end.next = node;
				node.pre = end;
				node.next = null;
			}
			end = node;
			if (head == null) {
				head = node;
			}
		}
	}

	public static class Node {
		Node pre;
		Node next;
		String key;
		String value;

		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
}
