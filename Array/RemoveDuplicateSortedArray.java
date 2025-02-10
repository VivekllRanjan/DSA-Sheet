package Array;

public class RemoveDuplicateSortedArray {
    public static int removeDuplicates(int[] arr) {
        int i =0;
        for (int j =1;j<arr.length;j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;

    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
