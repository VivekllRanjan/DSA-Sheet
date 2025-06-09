package StacksAndQueues;

import java.util.Stack;

public class LargestRectHistogram {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < cols; col++) {
                // Update the histogram: increment if '1', reset if '0'
                if (matrix[row][col] == '1') {
                    heights[col]++;
                } else {
                    heights[col] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] h) {
        int[] pse = findpse(h);
        int[] nse = findnse(h);

        int ans = 0;
        for(int i = 0; i < h.length; i++) {
            int width = nse[i] - pse[i] - 1;
            ans = Math.max(ans, h[i] * width);
        }

        return ans;
    }

    private int[] findpse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            res[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }

        return res;
    }

    private int[] findnse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            res[i] = (st.isEmpty()) ? arr.length : st.peek();
            st.push(i);
        }

        return res;
    }
}
