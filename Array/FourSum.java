package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n-3;i++){
            if(i>0 && arr[i] == arr[i-1]) continue; //skip i duplicate
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && arr[j] == arr[j-1]) continue; //skip j duplicates
                int p = j+1, q=n-1;
                while(p<q){
                    long sum = (long) arr[i]+arr[j]+arr[p]+arr[q];
                    if(sum==target){
                        ans.add(Arrays.asList(arr[i],arr[j],arr[p],arr[q]));
                        while(p<q && arr[p] == arr[p+1]) p++; //skip p duplicates
                        while(p<q && arr[q] == arr[q-1]) q--; //skip q duplicates
                        p++;
                        q--;
                    }
                    else if(sum<target) p++;
                    else q--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        System.out.println(fourSum(arr,0));

    }
}
