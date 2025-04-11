package Array;

public class BSSignleElement {
    public static void main(String[] args) {

    }
    public static int singleNonDuplicate(int[] arr) {

        int st = 0,end=arr.length-1;

        while(st<end){
            int mid = st+(end-st)/2;

            if(mid%2 == 1) mid--; //Always take mid as an even index

            if(arr[mid] == arr[mid+1]){
                //As mid is at even index and this condition is true, single element is at right of mid+1
                st = mid+2;
            }

            else{ //unique element is before or at mid
                end = mid;
            }
        }
        return arr[st];
    }
}
