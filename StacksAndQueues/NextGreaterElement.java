package StacksAndQueues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[nums2.length];

        for(int i = nums2.length - 1; i>=0; i--){
            while(!st.isEmpty() && nums2[i] >= st.peek()) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            mp.put(nums2[i], nge[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length;i++) {
            ans[i] = mp.get(nums1[i]);
        }

        return ans;
    }
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
