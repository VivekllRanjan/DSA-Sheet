package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        buildSum(candidates, target, new ArrayList<>(), ans, 0);

        return ans;
    }

    public void buildSum(int[] arr, int tar, List<Integer> curr, List<List<Integer>> ans, int idx){
        if(tar == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(idx == arr.length || tar < 0){
            return;
        }

        curr.add(arr[idx]); //Include
        buildSum(arr,tar-arr[idx],curr,ans,idx); //Add element again

        curr.remove(curr.size() - 1); //backtrack
        buildSum(arr,tar,curr,ans,idx+1);
    }
    public static void main(String[] args) {

    }
}
