package StacksAndQueues;

import java.util.Stack;

public class SumSubArrayMin {
    public int sumSubarrayMins(int[] arr) {
        int[] pse = findpse(arr);
        int[] nse = findnse(arr);

        int tot = 0;
        final int mod = 1_000_000_007;

        for(int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            tot = (int) ((tot + (long) left * right % mod * arr[i] % mod) % mod);
        }
        return tot;
    }

    private int[] findnse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }

        return nse;
    }

    private int[] findpse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }
}
