package Graphs;

import java.util.*;

public class AlienDictionary {
    private String alienDict(String[] words) {

        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        //Build graph
        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            for(int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1 != c2) {
                    //add edge from c1 to c2
                    adj.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    break;
                }
            }
        }

        //Apply topo sort
        Queue<Character> q = new LinkedList<>();
        for(char c : indegree.keySet()) {
            if(indegree.get(c) == 0){
                q.offer(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!q.isEmpty()) {
            char curr = q.poll();
            result.append(curr);

            for(char c : adj.get(curr)) {
                indegree.put(c, indegree.get(c) - 1);
                if(indegree.get(c) == 0) {
                    q.offer(c);
                }
            }
        }
        return result.length() == adj.size() ? result.toString() : "";
    }
}
