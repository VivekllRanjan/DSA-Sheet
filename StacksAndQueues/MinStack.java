package StacksAndQueues;

import java.util.Stack;

class MinStack {

    class Pair {
        int value;  // The actual value pushed
        int min;    // The minimum value so far

        Pair(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(val, stack.peek().min);
        stack.push(new Pair(val, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }
}