package Array;

public class BSKokoEatsBananas {

    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int calTotalH(int x, int[] arr) {
        double t = 0.0;
        for (int i = 0; i < arr.length; i++) {
            t += (arr[i] + x - 1L) / x;
            if (t > Integer.MAX_VALUE) return Integer.MAX_VALUE; // safety guard
        }
        return (int) t;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int st = 1, end = findMax(piles);

        while (st <= end) {
            int mid = st + (end - st) / 2;
            int tot = calTotalH(mid, piles);
            if (tot <= h) end = mid - 1;
            else st = mid + 1;
        }

        return st;
    }

    public static void main(String[] args) {
        int[] v = {7, 15, 6, 3};
        int h = 8;
        int ans = minEatingSpeed(v, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
}