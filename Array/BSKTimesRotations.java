package Array;

import java.util.List;

public class BSKTimesRotations {
    public static int findKRotation(List<Integer> arr) {
        // Code here
        int st=0, end=arr.size()-1;
        int min = Integer.MAX_VALUE;
        int ans = -1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(arr.get(st) <= arr.get(end)){
                if(arr.get(st) < min){
                    ans = st;
                    min = arr.get(st);
                }
                break;
            }
            if(arr.get(st) <= arr.get(mid)) //left sorted
            {
                if(arr.get(st) < min){
                    ans = st;
                    min = arr.get(st);
                }
                st = mid+1;
            }
            else //right sorted
            {
                end = mid-1;
                if(arr.get(mid) < min){
                    ans = mid;
                    min = arr.get(mid);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
