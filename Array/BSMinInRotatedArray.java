package Array;

public class BSMinInRotatedArray {
        public static int findMin(int[] arr) {

            int st=0,end=arr.length-1;
            int min = Integer.MAX_VALUE;
            while(st<=end){
                int mid = st+(end-st)/2;
                min = Math.min(min,arr[mid]);
                if(arr[st]<=arr[mid]) //left sorted
                {
                    min = Math.min(min,arr[st]);
                    st = mid+1;
                }
                else //right sorted
                {
                    min = Math.min(min,arr[mid]);
                    end = mid-1;
                }
            }

            return min;
        }

    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }
}
