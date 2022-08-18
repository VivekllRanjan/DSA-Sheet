package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
        public static int[] productExceptSelf(int[] nums) {

            int n = nums.length;

            int res[] = new int[n];

            res[0] = nums[0];
            for(int i=1;i<n;i++){
                res[i] = nums[i]*res[i-1];
            }

            int product = 1;
            for(int i=n-1;i>0;i--){

                res[i] = res[i-1]*product;
                product*=nums[i];

            }
            res[0] = product;

            return res;

        }
}
