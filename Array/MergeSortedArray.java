package Array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1,j=n-1;
        int index = nums1.length-1;
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[index] = nums1[i];
                i--;
                index--;
            }
            else{
                nums1[index] = nums2[j];
                j--;
                index--;

            }
        }
        while(j>-1){
            nums1[index] = nums2[j];
            index--;j--;
        }

    }

    public static void main(String[] args) {
        int[] arr1={1,2,3,0,0,0};
        int[] arr2={2,5,6};
        merge(arr1,3,arr2,3);

    }
}
