package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    public static List<List<Integer>> mergeOverlap(int[][] arr){
        int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();

        for(int i =0; i<n; i++){
            int start = arr[i][0];
            int end = arr[i][1];
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(arr[j][0] <= end){
                    end = Math.max(end,arr[j][1]);
                }
                else break;
            }
            ans.add(Arrays.asList(start,end));
        }

        return ans;
    }
    public static void main(String[] args) {

    }
}
