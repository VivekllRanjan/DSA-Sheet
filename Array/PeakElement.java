package Array;

public class PeakElement {
    public static int findPeakElement(int[] arr) {
        int st=0,end = arr.length-1;
        while(st<end){
            int mid = st+(end-st)/2;
            if(arr[mid] < arr[mid+1]) st = mid+1;
            else end = mid; // mid can be peak element aswell
        }

        return arr[st];
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int st =1, end= arr.length-2;
        while(st<end){
            int mid = st+(end-st)/2;
            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) return mid;
            if(arr[mid-1] < arr[mid]) st = mid+1;
            else end = mid -1;
        }
        return st;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        System.out.println(findPeakElement(arr));
    }
}
