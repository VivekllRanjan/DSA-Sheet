package StacksAndQueues;

import  java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') st.push(')');
            else if (ch == '{') st.push('}');
            else if (ch == '[') st.push(']');
            else if (st.isEmpty() || ch != st.pop())
                return false;
        }

        return st.isEmpty();  // Make sure all openings had a matching closing
    }
}
