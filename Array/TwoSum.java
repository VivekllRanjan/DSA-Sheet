package Array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSumHashing(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap();
        int diff;
        int[] ans = {-1,-1};
        for(int i=0; i<arr.length;i++){
            diff = k-arr[i];
            if(map.containsKey(diff)){
                ans[0] = map.get(diff);
                ans[1] = i;
                return ans;
            }
            map.put(arr[i],i);
        }

        return ans;
    }

    public static boolean twoSum2Pointer(int[] arr, int k){
        Arrays.sort(arr);
        int left = 0, right =arr.length-1;
        while(left<right){
            int sum = arr[left]+arr[right];
            if(sum == k){
                return true;
            }
            else if(sum<k) left++;
            else right--;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
