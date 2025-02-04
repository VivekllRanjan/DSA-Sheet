package Array;

import java.util.Arrays;

public class RotateArray {
    public static void rotateLeft(int[] nums, int d) {
        int[] temp = new int[d];
        int n = nums.length;
        for(int i=0;i<d;i++){
            temp[i] = nums[i];
        }

        for(int i=d;i<n;i++){
            nums[i-d]=nums[i];
        }

        for(int i=n-d; i<n; i++){
            nums[i] = temp[i-(n-d)];
        }

        System.out.println(Arrays.toString(nums));
    }
    public static void rotateRight(int[]nums,int k){
        int n=nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

        System.out.println(Arrays.toString(nums));
    }
    private static void reverse(int[]nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        rotateLeft(nums1, 3);
        System.out.println();
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        rotateRight(nums2,3);
    }

}
