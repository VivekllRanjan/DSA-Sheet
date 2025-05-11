package DynamicProgramming;

import java.util.Arrays;

public class MinCostClimbing {
    public int minCostClimbingStairsTabulation(int[] cost) {
        int n = cost.length;
        int prev1 = cost[1], prev2 = cost[0];

        for(int i=2; i<n;i++) {
            int curr = cost[i] + Math.min(prev1,prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev1,prev2);
    }
    public int minCostClimbingStairsMemorization(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(helper(cost, dp,  n- 1), helper(cost, dp, n - 2));
    }
    private int helper(int[] cost, int[] dp, int n) {
        if(n<0) return 0;
        if(n == 0 || n == 1) return cost[n];

        if(dp[n] != -1) return dp[n];

        int one = helper(cost, dp, n-1) + cost[n];
        int two = helper(cost, dp, n-2) + cost[n];

        return dp[n] = Math.min(one, two);
    }
}
