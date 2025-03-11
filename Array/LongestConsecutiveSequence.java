package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums){
        int ans = 0;
        Arrays.sort(nums);
        int count =0, lastnum=Integer.MIN_VALUE;
        for(int i:nums){
            if (i == lastnum+1){ //This is next number
                count++;
                lastnum = i;
                ans = Math.max(ans,count);
            }
            else if (i !=lastnum){
                lastnum = i;
                count =1;
            }
        }
        return ans;
    }

    public static int longestSuccessiveHashing(int[] a) {
        int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveHashing(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
}
