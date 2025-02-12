package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayLeader {
    public static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();

        int max = arr[arr.length-1];
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>=max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.sort(ans,Collections.reverseOrder());
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        System.out.println(leaders(arr));
    }

}
