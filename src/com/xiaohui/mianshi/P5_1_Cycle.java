package com.xiaohui.mianshi;

public class P5_1_Cycle {

    /**
     * 是否有环
     */
    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            System.out.println("isCycle:p1=" + p1);
            System.out.println("isCycle:p2=" + p2);
            if (p2 != null) {
                p2 = p2.next;
            }
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 环的长度
     */
    public static int cycleLen(Node head) {
        boolean cycle = false;
        int len = 0;
        Node p1 = head;
        Node p2 = head;
        while (p1 != null && p2 != null) {
            if (cycle) {
                len++;
            }
            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null) {
                p2 = p2.next;
            }
            if (p1 == p2) {
                System.out.println("cycleLen:cycle=" + cycle);
                if (!cycle) {
                    cycle = true;
                } else {
                    break;
                }
            }
        }
        return len;
    }

    /**
     * 找到环的入口
     */
    public static Node cycleEnter(Node head) {
        Node p1 = head;
        Node p2 = head;
        Node pmeet = null;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null) {
                p2 = p2.next;
            }
            if (p1 == p2) {
                pmeet = p1;
                System.out.println("cycleEnter:pmeet=" + pmeet);
                break;
            }
        }
        if (pmeet != null) {
            p1 = head;
            while (p1 != null && pmeet != null) {
                if (p1 == pmeet) {
                    return p1;
                }
                p1 = p1.next;
                pmeet = pmeet.next;
            }
        }
        return null;
    }

    //5->8->9->7->2->6
    //      ^        \
    //      |--------\
    public static void main(String[] args) {
        Node node1 = new Node(5, 1);
        Node node2 = new Node(8);
        Node node3 = new Node(9,3);
        Node node4 = new Node(7);
        Node node5 = new Node(2);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        boolean cycle = isCycle(node1);
        System.out.println("cycle=" + cycle);
        int cycleLen = cycleLen(node1);
        System.out.println("cycleLen=" + cycleLen);
        Node cycleMeet = cycleEnter(node1);
        System.out.println("cycleEnter=" + cycleMeet);
    }

    private static class Node {
        int index;
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, int index) {
            this.data = data;
            this.index = index;
        }

        @Override
        public String toString() {
            if (index != 0) {
                return "data=" + data + ",i=" + index;
            }
            return "data=" + data;
        }
    }
}
