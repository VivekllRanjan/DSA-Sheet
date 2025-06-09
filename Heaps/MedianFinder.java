package Heaps;

import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> smallHeap; //maxHeap
    private PriorityQueue<Integer> largeHeap; //minHeap

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        largeHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        // Step 1: Add to maxHeap
        smallHeap.offer(num);

        // Step 2: Balance - move max of smallHeap to largeHeap
        largeHeap.offer(smallHeap.poll());

        // Step 3: Rebalance if largeHeap is larger
        if (largeHeap.size() > smallHeap.size()) {
            smallHeap.offer(largeHeap.poll());
        }
    }

    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        } else {
            return smallHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */