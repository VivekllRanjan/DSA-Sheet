package DynamicProgramming;

import java.util.Arrays;

public class RobHouse {
    public int robMemoization(int[] house) {
        int n = house.length - 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return maxRob(house, n, dp);
    }

    private int maxRob(int[] house, int n, int[] dp) {
        if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];

        int pick = house[n] + maxRob(house, n-2, dp);
        int skip = maxRob(house, n-1, dp);

        return dp[n] = Math.max(pick,skip);
    }

    public int robTabulation(int[] house) {
        int n = house.length;
        if (n == 0) return 0;
        if (n == 1) return house[0];

        int prev2 = house[0];
        int prev1 = Math.max(house[0], house[1]);

        for(int i = 2; i<n; i++) {

            int pick = house[i] + prev2;
            int skip = prev1;

            int curr = Math.max(pick, skip);

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
