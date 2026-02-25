package Array;

import java.util.ArrayList;
import java.util.List;

public class MinPairRemoval {
    boolean isSorted(List<Integer> nums) {
        for(int i = 0; i < nums.size() - 1; i++) {
            if(nums.get(i) > nums.get(i+1)) return false;
        }

        return true;
    }
    int minSumPair(List<Integer> nums) {
        int pos = -1, minSum = Integer.MAX_VALUE;
        for(int i = 0; i < nums.size() - 1; i++) {
            int sum = nums.get(i) + nums.get(i+1);
            if(sum < minSum) {
                minSum = sum;
                pos = i;
            }
        }
        return pos;
    }
    void mergeMinPair(List<Integer> nums, int pos) {
        nums.set(pos, nums.get(pos)+ nums.get(pos+1));
        nums.remove(pos+1);
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> v = new ArrayList<>();
        for(int num : nums) v.add(num);

        int ans = 0;
        while(!isSorted(v)) {
            int pos = minSumPair(v);
            mergeMinPair(v, pos);
            ans++;
        }
        return ans;
    }
}
