package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class RearragePosNegAlternate {
    public static int[] rearrangeArray(int[] arr){
        int n = arr.length;

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(arr[i]>0){
                pos.add(arr[i]);
            }
            else neg.add(arr[i]);
        }
        for(int i =0;i<n/2;i++){
            arr[2*i] = pos.get(i);
            arr[2*i+1] = neg.get(i);
        }
        return arr;
    }
    public static int[] rearrangeArrayOptimal(int[] arr){
        int pos=0,neg=1;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                ans.set(pos,arr[i]);
                pos+=2;
            }
            else{
                ans.add(neg,arr[i]);
                neg+=2;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {3,1,-2,-5,2,-4};
        int[] sol1 = rearrangeArray(arr);
        int[] sol2 = rearrangeArrayOptimal(arr);
        System.out.println(Arrays.toString(sol1));
        System.out.println(Arrays.toString(sol2));

    }
}
