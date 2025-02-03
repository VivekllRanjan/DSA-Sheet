package Array;

public class SecondLargestNumberInArray {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int lar = arr[0];
        int slar = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > lar) {
                slar = lar;
                lar = arr[i];
            } else if (arr[i] > slar && arr[i] != lar) {
                slar = arr[i];
            }
        }
        return slar;

    }

    public static void main(String[] args) {

    }
}
