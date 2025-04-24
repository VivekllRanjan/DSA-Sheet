package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(),used,ans);

        return ans;
    }

    public void backtrack(int[] arr, List<Integer> curr, boolean[] used, List<List<Integer>> ans){
        if(curr.size() == arr.length){
            ans.add(new ArrayList<>(curr)); return;
        }

        //build permutation by taking each element
        for(int i = 0;i<arr.length;i++){
            if(used[i]) continue;

            if(i>0 && arr[i] == arr[i-1] && !used[i-1]) continue;

            //Choose ith element to build the curr permutation
            curr.add(arr[i]);
            used[i] = true;

            //Recursively build the curr
            backtrack(arr,curr,used,ans);

            //Backtrack to take next permutation
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {

    }
}
