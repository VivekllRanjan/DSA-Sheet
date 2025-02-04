package Array;

public class SingleAppearanceInArray {
    public static  int singleNumber(int[] nums) {

        int XOR=0;;
        for (int num : nums) {
            XOR = XOR ^ num;
        }

        return XOR;

    }
    public static void main(String[] args) {

        int[] a = {2,2,1};
        System.out.println(singleNumber(a));

    }
}
