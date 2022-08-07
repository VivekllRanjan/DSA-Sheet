package Array;

public class MaxSubArrayKadane {
    public static void main(String[] args) {
        int arr[] = {1,-2,3,4,5};
        System.out.println(MaxSum(arr));
    }

    private static int MaxSum(int[] nums) {
        int Max_so_far = Integer.MIN_VALUE;
        int Max_ending_here = 0;

        for(int i=0;i<nums.length;i++){
            Max_ending_here+=nums[i];
            if(Max_ending_here>Max_so_far){
                Max_so_far = Max_ending_here;
            }
            if(Max_ending_here <0){
                Max_ending_here = 0;
            }
        }
        return Max_so_far;
    }
}
