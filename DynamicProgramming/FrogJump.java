package DynamicProgramming;

import java.util.Arrays;

public class FrogJump {
    private int frogJump(int[] cost, int k) {
        int n = cost.length-1;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return helper(cost,n,k,dp);

    }

    private int helper(int[] cost, int n, int k, int[] dp) {
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];

        int minCost = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++) {
            if(n-j >= 0) {
                int now = helper(cost, n - j, k, dp) + Math.abs(cost[n] - cost[n - j]);
                minCost = Math.min(minCost, now);
            }
        }
        return dp[n] = minCost;
    }

    private int frogJumpTabulation(int[] cost, int k) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i = 1; i < n; i++ ) {
            int minCost = Integer.MAX_VALUE;
            for(int j = 1; j <= k && i - j >= 0; j++ ) {
                int jump = dp[i - j] + Math.abs(cost[i] - cost[i - j]);
                minCost = Math.min(minCost, jump);
            }
            dp[i] = minCost;
        }

        return dp[n-1];
    }
}
