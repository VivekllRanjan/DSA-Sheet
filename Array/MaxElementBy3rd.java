package Array;

import java.util.ArrayList;
import java.util.List;

public class MaxElementBy3rd {
    public List<Integer> majorityElement(int[] arr) {

        int c1=0,c2=0,e1=Integer.MIN_VALUE,e2=Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(c1 == 0 && arr[i] != e2){
                c1=1; e1=arr[i];
            }
            else if(c2 ==0 && arr[i] != e1){
                c2=1; e2=arr[i];
            }
            else if(arr[i] == e1) c1++;
            else if(arr[i] == e2) c2++;
            else{
                c1--;c2--;
            }
        }

        List<Integer> ans = new ArrayList<>();

        c1=0;c2=0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == e1) c1++;
            if(arr[i] == e2) c2++;
        }

        int min = (int) (arr.length/3) + 1;

        if(c1 >= min) ans.add(e1);
        if(c2 >= min) ans.add(e2);
        return ans;

    }
}
