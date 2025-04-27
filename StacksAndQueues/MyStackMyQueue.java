package StacksAndQueues;


public class MyStackMyQueue {

    public static void main(String[] args) {
        //QUsingStacks outer = new QUsingStacks();
        MyQueue queue = new MyQueue();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Peek: " + queue.peek()); // Should print 10
        System.out.println("Pop: " + queue.pop());   // Should print 10
        System.out.println("Pop: " + queue.pop());   // Should print 20
        System.out.println("Empty: " + queue.empty()); // Should print false
        System.out.println("Pop: " + queue.pop());   // Should print 30
        System.out.println("Empty: " + queue.empty()); // Should print true

        System.out.println();

        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top()); // 3
        System.out.println("Pop: " + stack.pop()); // 3
        System.out.println("Pop: " + stack.pop()); // 2
        System.out.println("Empty: " + stack.empty()); // false
        System.out.println("Pop: " + stack.pop()); // 1
        System.out.println("Empty: " + stack.empty()); // true
    }
}

