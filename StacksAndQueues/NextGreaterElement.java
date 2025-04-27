package StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];

        for(int i = 2*nums.length-1; i>=0; i--) {
            while(!st.isEmpty() && nums[i % n] >= st.peek()) {
                st.pop();
            }
            if(i < n){
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(nums[i % n]);
        }

        return nge;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 1};
        System.out.println("Next Greater Elements: " + Arrays.toString(nextGreaterElements(nums1)));

        // Test case 2
        int[] nums2 = {3, 2, 1, 4, 5};
        System.out.println("Next Greater Elements: " + Arrays.toString(nextGreaterElements(nums2)));
    }
}
