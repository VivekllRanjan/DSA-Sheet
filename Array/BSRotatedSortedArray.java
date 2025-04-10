package Array;

public class BSRotatedSortedArray {
    public static boolean search(int[] arr, int tar) {

        int st = 0, end = arr.length-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(arr[mid] == tar) return true;
            if(arr[st] == arr[mid] && arr[mid] == arr[end]) { //deal with duplicate elements in the start and end
                st++;
                end--;
            }
            else if(arr[st]<=arr[mid]) //left sorted
            {
                if(arr[st]<=tar && tar<=arr[mid]) end = mid-1;
                else st = mid+1;
            }
            else //right sorted
            {
                if(arr[end]>=tar && tar>=arr[mid]) st = mid+1;
                else end = mid-1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int arr[] = {2,5,6,0,0,1,2};
        System.out.println(search(arr,0));
    }
}
