package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperSet {

    public void subsetHelper(int[] arr, List<List<Integer>> ans, List<Integer> subsets, int i) {
        if(i==arr.length){
            ans.add(new ArrayList<>(subsets));
            return;
        }

        //Include element
        subsets.add(arr[i]);
        subsetHelper(arr,ans,subsets,i+1);

        //Clear last element to exclude
        subsets.remove(subsets.size() - 1);

        //Exclude
        subsetHelper(arr,ans,subsets,i+1);
    }

    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();
        subsetHelper(arr, ans, subsets,0);

        return ans;
    }
}
