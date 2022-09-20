package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8};
        int sum = 8;
        List<List<Integer>> ans= combinationsAns(arr, sum);
        System.out.println(ans);
    }

    public static List<List<Integer>> combinationsAns(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        findCombination(0,arr,target,result,new ArrayList<>());
        return result;
    }


    //i -> index        arr -> i/p array        t -> target         ans -> result array         ds -> picked items
    private static void findCombination(int i, int[] arr, int t, List<List<Integer>> ans, List<Integer> ds) {
        if(i == arr.length)//All ele traversed
        {
            if(t == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        //check if current picked element is less or equal to target
        if(arr[i] <= t){
            ds.add(arr[i]);
            findCombination(i,arr,t-arr[i],ans,ds);
            //When recursion is back with or without summing to target, pick the non-picked to check further results
            ds.remove(ds.size()-1);
        }
        findCombination(i+1,arr,t,ans,ds);
    }
}
