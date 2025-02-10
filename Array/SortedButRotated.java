package Array;

public class SortedButRotated {
    public static boolean check(int[] nums) {
        int n = nums.length;
        int count =0;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]) //Circular check. If i=n-1, it compares it to the 1st element (n-1+1)%n =0
                count++;
            if(count>1) //More than 1 breaks means not rotated sorted array
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(check(arr));
    }
}
