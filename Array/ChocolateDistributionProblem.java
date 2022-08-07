/*
Given an array of n integers where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that:

1. Each student gets one packet.
2. The difference between the number of chocolates in the packet with maximum chocolates and packet with minimum
chocolates given to the students is minimum.
 */

package Array;

import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int arr[] = {12, 4, 7, 9, 2, 23, 25, 41,
                30, 40, 28, 42, 30, 44, 48,
                43, 50};
        System.out.println(MinDiff(arr,7));
    }

    private static int MinDiff(int[] arr, int m) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for(int i=0; i<arr.length && i+m-1<arr.length; i++){
            int check = arr[i+m-1] - arr[i];
            if(check < diff){
                diff = check;
            }
        }

        return diff;
    }
}
