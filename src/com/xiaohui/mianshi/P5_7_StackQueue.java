package com.xiaohui.mianshi;

import java.util.Stack;

public class P5_7_StackQueue {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    public void enQueue(int element) {
        stackA.push(element);
    }

    public Integer deQueue() {
        if (stackB.isEmpty()) {
            if (stackA.empty()) {
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    private void transfer() {
        int times = 0;
        while (!stackA.isEmpty()) {
            times++;
            stackB.push(stackA.pop());
        }
        System.out.println("transfer:times=" + times);
    }

    public static void main(String[] args) {
        P5_7_StackQueue stackQueue = new P5_7_StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }

}
