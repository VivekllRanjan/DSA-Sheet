package DynamicProgramming;

import java.util.Arrays;

public class NinjaTraining {
    private static int ninjaTraining(int n, int points[][]) {

        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return calPoints(n-1, 3, points, dp);

    }

    private static int calPoints(int day, int lastTask, int[][]points, int[][] dp) {

        if(day == 0) {
            int maxi = -1;
            for(int i = 0; i<3; i++) {
                if(i != lastTask) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }

        if(dp[day][lastTask] != -1) return dp[day][lastTask];

        int maxi = 0;
        for(int i = 0; i<3; i++) {
            if(i != lastTask) {
                int point = points[day][i] + calPoints(day - 1, i, points, dp);
                maxi = Math.max(maxi, point);
            }
        }

        return dp[day][lastTask] = maxi;
    }

    public static int ninjaTrainingTabulation(int n, int[][] points) {

        int[] prev = new int[4];

        // Base case for day 0
        for (int last = 0; last < 4; last++) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    max = Math.max(max, points[0][task]);
                }
            }
            prev[last] = max;
        }

        // From day 1 to day n-1
        for (int day = 1; day < n; day++) {
            int[] curr = new int[4];
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + prev[task];
                        max = Math.max(max, point);
                    }
                }
                curr[last] = max;
            }
            prev = curr;
        }

        return prev[3]; // Last task as 3 means "no task restriction"
    }

    public static void main(String[] args) {
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };
        int n = points.length;
        int result = ninjaTraining(n, points);
        System.out.println("Maximum points the ninja can get: " + result);  // Expected: 210
    }
}
