package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x);  // Add to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());  // Move all from q1 to q2
        }
        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.poll();
    }

    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

}
