package Array;

public class Sort0s1s2s {
    public void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length-1;
        while(mid<=high){
            if(arr[mid] == 0){
                int t = arr[mid];
                arr[mid] = arr[low];
                arr[low] = t;
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                int t = arr[mid];
                arr[mid] = arr[high];
                arr[high] = t;
                high--;
            }
        }
    }
}
