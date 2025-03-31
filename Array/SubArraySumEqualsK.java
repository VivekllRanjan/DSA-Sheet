package Array;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static int subArrSum(int[] arr, int k){
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int PrefixSum = 0;
        map.put(0,1);
        for(int i=0; i< arr.length; i++){
            PrefixSum+=arr[i];
             int diff = PrefixSum - k;
             count+=map.getOrDefault(diff,0);

             map.put(PrefixSum,map.getOrDefault(PrefixSum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {3,1,2,4};
        int k = 6;
        System.out.println(subArrSum(arr,k));
    }
}
