package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        getPerms(nums, new ArrayList<>(), used, ans);

        return ans;
    }

    public void getPerms(int[] arr, List<Integer> curr, boolean[] used, List<List<Integer>> ans) {
        if(curr.size() == arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0;i < arr.length; i++){
            if(used[i]) continue; //skip used number

            curr.add(arr[i]);
            used[i] = true;

            getPerms(arr, curr, used, ans);

            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
