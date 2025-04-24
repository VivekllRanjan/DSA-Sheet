package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        buildSum(candidates, 0, target, new ArrayList<>(), ans);

        return ans;
    }

    public void buildSum(int[] arr, int start, int tar, List<Integer> curr, List<List<Integer>> ans) {
        if(tar == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < arr.length; i++){
            if(i > start && arr[i] == arr[i-1]) continue; //skip duplicates

            if(arr[i] > tar) break; //skip building curr as no point

            curr.add(arr[i]);
            buildSum(arr, i+1, tar-arr[i], curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
