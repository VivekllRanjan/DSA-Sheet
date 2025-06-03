package Heaps;

import java.util.PriorityQueue;

public class KthLargestInArray {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for(int num : nums) {
                minHeap.offer(num);

                if(minHeap.size() > k) minHeap.poll();
            }

            return minHeap.isEmpty() ? 0 : minHeap.peek();
        }
    }
}
