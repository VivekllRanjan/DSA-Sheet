package Array;

import java.util.Arrays;

public class MaxSubArrayKadane {
    public static void main(String[] args) {
        int arr[] = {100,0,-101,300,-4,-5};
        int sol[] = MaxSum(arr);
        System.out.println(Arrays.toString(sol));
    }

    private static int[] MaxSum(int[] nums) {
        int Max_so_far = Integer.MIN_VALUE;
        int Max_ending_here = 0;
        int[] ans ={0,-1,-1};
        int ansStart =-1, ansEnd =-1, start = -1;
        for(int i=0;i<nums.length;i++){
            if(Max_ending_here == 0){
                start = i;
            }
            Max_ending_here+=nums[i];
            if(Max_ending_here>Max_so_far){
                Max_so_far = Max_ending_here;
                ansStart = start;
                ansEnd = i;
            }
            if(Max_ending_here <0){
                Max_ending_here = 0;
            }
        }
        ans[0] = Max_so_far;
        ans[1] = ansStart;
        ans[2] = ansEnd;
        return ans;
    }
}
