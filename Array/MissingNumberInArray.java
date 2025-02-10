package Array;

public class MissingNumberInArray {
    public static int missingNumberXOR(int[] nums) {

        int n = nums.length;
        int XOR1 = 0;
        int XOR2 = 0;
        for(int i=0;i<n;i++){
            XOR1 = XOR1 ^ nums[i];
            XOR2 = XOR2 ^ (i+1);
        }

        return XOR1 ^ XOR2;
    }
    public static int missingNumber(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int nsum = n*(n+1)/2;
        return nsum-sum;
    }
    public static void main(String[] args) {
        int a[] = {3,0,1};
        System.out.println(missingNumber(a));
        System.out.println(missingNumberXOR(a));
    }
}
