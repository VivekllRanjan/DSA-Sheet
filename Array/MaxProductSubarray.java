package Array;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(maxProduct(arr));
    }
    public static int maxProduct(int[] nums) {

        int Max = nums[0];
        int Min = nums[0];
        int ans = nums[0];
        for(int i =1; i<nums.length; i++){

            if(nums[i]<0){
                int t = Max;
                Max = Min;
                Min = t;
            }

            Max = Math.max(nums[i], nums[i]*Max);
            Min = Math.min(nums[i], nums[i]*Min);

            ans = Math.max(Max,ans);

        }

        return ans;
    }
}
