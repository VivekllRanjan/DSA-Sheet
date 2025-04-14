package Array;

public class BSMinDaysBouquets {
    public static int findBouquets(int k, int[] arr, int d){
        int count =0, bouquets =0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<=d){
                count++;
                if(count == k) {
                    bouquets++;
                    count =0;
                }
            }
            else count =0;
        }
        return bouquets;
    }

    public static int findMax(int[] arr){
        int max =Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        long totFlowers = (long) m*k;
        if(totFlowers > bloomDay.length) return -1;

        int st = 1,end = findMax(bloomDay);
        int ans = -1;

        while(st<=end){
            int mid = st+(end-st)/2;
            int count = findBouquets(k,bloomDay,mid);

            if(count>=m){
                ans = mid;
                end = mid-1;
            }
            else st = mid+1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {7,7,7,7,12,7,7};
        System.out.println(minDays(arr,2,3));
    }
}
