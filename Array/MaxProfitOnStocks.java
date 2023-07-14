package Array;

public class MaxProfitOnStocks {
    public static void main(String[] args) {
        int A[] = {7,6,4,3,1};
        System.out.println(maxProfit(A));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minCost = prices[0];
        //int cost;
        for(int i=1;i<prices.length;i++){
            minCost = Math.min(prices[i],minCost);
            int profit = prices[i] - minCost;
            maxProfit = Math.max(profit,maxProfit);
        }

        return maxProfit;

    }
}

