package Array;

public class StockBuyAndSell {
    public static int maxProfit(int[] arr) {
        int n = arr.length;
        int buy = arr[0], profit = 0;
        int diff = 0;
        for (int i = 1; i < n; i++){
            diff = arr[i] - buy;
            profit = Math.max(profit,diff);
            buy = Math.min(buy,arr[i]);
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
