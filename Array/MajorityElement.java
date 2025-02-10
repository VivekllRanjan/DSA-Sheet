package Array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] arr) {
        int ele=-1,cnt = 0, n = arr.length;
        for(int i=0;i<n;i++){
            if(cnt == 0){
                cnt = 1;
                ele = arr[i];
            }
            else if(arr[i] == ele) cnt++;
            else cnt--;

        }
        return ele;
    }
    public static int majorityElementHashing(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int ele = -1, n = arr.length;
        for(int i=0;i<arr.length;i++){
            int value = map.getOrDefault(arr[i],0);
            map.put(arr[i],value+1);
        }
        for(Map.Entry<Integer,Integer> i : map.entrySet()){
            if(i.getValue() > (n/2))
                return i.getKey();
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
