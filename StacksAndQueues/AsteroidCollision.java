package StacksAndQueues;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();

        for(int a : ast) {
            boolean alive = true;

            while(alive && !st.isEmpty() && st.peek() > 0 && a < 0) {
                int top = st.peek();
                if (Math.abs(top) == Math.abs(a)) {
                    // Same size: both explode
                    st.pop();
                    alive = false;
                } else if (Math.abs(top) > Math.abs(a)) {
                    // Top asteroid bigger: current explodes
                    alive = false;
                } else {
                    // Current asteroid bigger: pop top and keep checking
                    st.pop();
                }
            }
            if (alive) {
                st.push(a);
            }
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}
