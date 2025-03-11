package Array;

import java.util.Arrays;

public class RotateMatrix {
    public static int[][] rotate(int[][] arr) {

        int n = arr.length;

        transpose(arr);

        for(int i=0;i<n;i++){
            reverse(arr[i]);
        }
        return arr;
    }

    public static void transpose(int[][] arr){
        int n = arr[0].length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void reverse(int[] arr){
        int n = arr.length;
        int left = 0, right=n-1;
        while(left<right){
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;right--;
        }
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        arr = rotate(arr);
        for(int i=0;i<arr[0].length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
