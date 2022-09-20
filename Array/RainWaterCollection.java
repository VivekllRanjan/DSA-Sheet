package Array;

/*
https://leetcode.com/problems/trapping-rain-water/
 */

public class RainWaterCollection {
    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Water stored: " + collected(height));
    }

    private static int collected(int[] h) {
        int n = h.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = h[0];
        for (int i =1; i<n; i++){
            left[i] = Math.max(left[i-1],h[i]);
        }

        right[n-1] = h[n-1];
        for(int i=n-2; i>=0; i--){
            right[i] = Math.max(right[i+1],h[i]);
        }

        int res =0;
        for(int i =0;i<n;i++){
            int add = Math.min(left[i],right[i])-h[i];
            res+=add;
        }

        return res;
    }
}
