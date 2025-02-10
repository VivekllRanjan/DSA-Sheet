package Array;

import java.util.ArrayList;
import java.util.List;

public class FrequenciesInArray {
    public static void main(String[] args) {
        int[] arr ={2,3,2,3,5,4,1,1};
        freq(arr);
    }

    private static void freq(int[] arr) {
        int l= arr.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            res.add(0);
        }

        for(int num : arr){
            if(num>=1 && num<=l){
                res.set(num-1,res.get(num-1 )+1);
            }
        }
        for(int i=0; i<l; i++){
            System.out.print(res.get(i)+ " ");
        }
    }
}
