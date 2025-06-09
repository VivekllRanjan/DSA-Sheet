package Heaps;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int[] taskFreq = new int[26];
        for(char c : tasks) {
            taskFreq[c - 'A']++;
        }

        for(int t : taskFreq) {
            if(t != 0) maxHeap.offer(t);
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if(!maxHeap.isEmpty()) {
                int freq = maxHeap.poll() - 1;
                if(freq > 0) q.offer(new int[]{freq, time + n});
            }

            if(!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}
