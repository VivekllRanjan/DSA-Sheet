package Array;

public class BSShippingInDays {
    public static int sumWeight(int[] arr){
        int tot=0;
        for(int i:arr){
            tot+=i;
        }
        return tot;
    }
    public static int maxWeight(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i : arr) max = Math.max(max, i);
        return max;
    }

    public static int checkDays(int[]arr, int cap){
        int days = 1, count=0;
        for(int i:arr){
            if(count+i <= cap)
            {
                count+=i;
            }
            else {
                days++;
                count =i;
            }
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int st=maxWeight(weights);
        int end = sumWeight(weights);
        int ans =-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            int check = checkDays(weights,mid);
            if(check <= days){
                ans=mid;
                end=mid-1;
            }
            else st=mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(arr,5));
    }
}
