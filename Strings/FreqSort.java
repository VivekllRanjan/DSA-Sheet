package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FreqSort {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        StringBuilder res = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int f = map.get(ch);
            res.append(String.valueOf(ch).repeat(f));
        }

        return res.toString();
    }
}
