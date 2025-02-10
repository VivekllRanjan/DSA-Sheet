package Array;

import java.util.HashMap;
import java.util.Map;

public class LongestSArrWithSumK {
    public static int longestSubarrayBrute(int[] arr, int k) {
        // code here
        int len = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum == k)    len = Math.max(len,j-i+1);
            }
        }
        return len;
    }

    public static int longestSubArrayHashing(int[] arr, int k){
        int len = 0;
        long sum = 0;
        int n = arr.length;
        Map<Long, Integer> preSumMap = new HashMap<>();
        for(int i = 0; i<n; i++){
            sum+=arr[i];
            if(sum == k){
                len = Math.max(len,i+1);
            }
            long rem = sum - k;
            if(preSumMap.containsKey(rem)){
                int l = i-preSumMap.get(rem);
                len = Math.max(len,l);
            }
            if(!preSumMap.containsKey(sum))
                preSumMap.put(sum,i);
        }

        return len;

    }

    public static int OnlyPositiveNumbersInArray(int[] arr,int k){
        int len = 0;
        int n = arr.length;
        int i=0,j=0;
        int sum = arr[0];
        while(j<n){
            while(sum>k && i<j){
                sum-=arr[i];
                i--;
            }
            if(sum == k) len = Math.max(len,j-i+1);

            j++;
            sum+=arr[j];
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = longestSubArrayHashing(a, k);
        System.out.println("The length of the longest subarray is: " + len);

    }
}
