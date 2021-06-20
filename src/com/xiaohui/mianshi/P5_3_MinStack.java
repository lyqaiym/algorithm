package com.xiaohui.mianshi;

import java.util.Stack;

public class P5_3_MinStack {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int element) {
        mainStack.push(element);
        if (minStack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    public void pop() {
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        mainStack.pop();
    }

    public int getMin() throws Exception {
        if (minStack.isEmpty()) {
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        P5_3_MinStack minStack = new P5_3_MinStack();
        minStack.push(4);
        minStack.push(9);
        minStack.push(7);
        minStack.push(3);
        minStack.push(8);
        minStack.push(5);
        try {
            System.out.println("getMin1=" + minStack.getMin());
        } catch (Exception e) {
            e.printStackTrace();
        }
        minStack.pop();
        minStack.pop();
        minStack.pop();
        try {
            System.out.println("getMin2=" + minStack.getMin());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
