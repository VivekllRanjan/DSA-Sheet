package StacksAndQueues;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }

            st.push(c);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        // Reverse since we built the number backwards
        res.reverse();
        // Remove leading zeroes
        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        // If empty after removing leading zeroes, return "0"
        return res.length() == 0 ? "0" : res.toString();

    }
}
