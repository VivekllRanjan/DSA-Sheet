//https://leetcode.com/problems/next-permutation/

package Array;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int arr[] = {1,2,3};

        NextP(arr);

    }
    private static void NextP(int nums[]){
        int idx1=0;
        int idx2=0;
        if(nums.length<=1)
            return ;
        for(int i = nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                idx1 = i;
                break;
            }
        }
        for(int i = nums.length-1;i>=0;i--)
        {
            if(nums[idx1]<nums[i])
            {
                idx2 = i;
                break;
            }
        }

        swap(nums,idx1,idx2);
        if(idx1==0 && idx2==0)
            reverse(nums,idx1,nums.length-1);
        else
            reverse(nums,idx1+1,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void swap(int[] nums,int a,int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void reverse(int[] nums,int a,int b){
        while(a<b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }
    }
}
